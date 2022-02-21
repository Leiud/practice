package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author echo
 * @date 2021年 12月 09日 16:09
 */
@Slf4j
@RestController
public class PaymentController {

    /**
     * 获取端口号
     */
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "SpringCloud with ZooKeeper：" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
