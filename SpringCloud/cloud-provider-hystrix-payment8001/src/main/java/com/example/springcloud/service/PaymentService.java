package com.example.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author echo
 * @date 2021年 12月 22日 21:16
 */
@Service
public class PaymentService {

    /**
     * 正常访问方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "\t paymentInfo_OK，id：" + id;
    }


    /**
     * 超时访问方法
     *
     * @HystrixCommand 降级配置，可以在里面指定 超时/出错 的回调方法，作为兜底方法
     * 一旦调用服务方法失败并抛出错误信息后，会自动调用 @HystrixCommand 标注好的 fallbackMethod 调用类中的指定方法
     * @param id
     * @return
     */
    @HystrixCommand(
            // 超时后回调方法
            fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {
            //设置自身超时调用时间的峰值为 3 秒，峰值内可以正常运行，超过了需要有兜底的方法 fallbackMethod 处理，服务降级 fallback
            @HystrixProperty(
                    // 时间单位
                    name = "execution.isolation.thread.timeoutInMilliseconds",
                    // 超时时间
                    value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 5;
        int i = 1 / 0;
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池：" + Thread.currentThread().getName() +
                "\t paymentInfo_TimeOut，id：" + id + "，耗时：" + timeNumber + "秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "8001 提供者，线程池：" + Thread.currentThread().getName() +
                "\t paymentInfo_TimeOutHandler 系统繁忙，请稍后再试，id：" + id;
    }



    //=====服务熔断


    /**
     * 在 10s 内 10 次请求有 60% 失败就打开断路器，先看次数，再看百分比
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                      //开启断路器
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),         //请求总数阈值（默认20）
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   //休眠时间窗口期（休眠多久进入半开模式（单位毫秒，默认5秒））
            // 失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),       //请求次数的错误率达到多少跳闸（百分率%，默认50%）
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            throw  new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return  Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数,请稍后再试， id: " + id;
    }
}
