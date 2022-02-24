package com.example.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author echo
 * @date 2021年 12月 23日 22:28
 */

/**
 * 统一为接口里面的方法进行异常处理
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    /**
     * 兜底方法，根据上述配置，程序内发生异常、或者运行超时，都会执行该兜底方法
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_OK----";
    }

    /**
     * 兜底方法，根据上述配置，程序内发生异常、或者运行超时，都会执行该兜底方法
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_TimeOut----";
    }
}