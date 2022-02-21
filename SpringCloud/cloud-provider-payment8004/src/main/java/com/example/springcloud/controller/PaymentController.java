package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Slf4j  日志
 * @RestController   必须是这个注解，因为是模拟前后端分离的 restful 风格的请求，要求每个方法返回 json
 */
@Slf4j
@RestController
public class PaymentController {

    /**
     * 获取端口号
     */
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentZK(){
        return "SpringCloud with ZooKeeper：" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}