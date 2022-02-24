package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author echo
 * @date 2021年 12月 22日 22:01
 */
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
@Slf4j
@RestController
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    // @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
    //        @HystrixProperty(
    //                name = "execution.isolation.thread.timeoutInMilliseconds",
                    // 只等 1.5 s
    //                value = "1500")
    // })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        // int i = 10 /0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "消费者 80，支付系统繁忙";
    }

    /**
     * 全局 fallback 方法，不能有传参
     * @return
     */
    public String payment_Global_FallbackMethod(){
        return "Global 异常处理信息，请稍后再试！";
    }
}
