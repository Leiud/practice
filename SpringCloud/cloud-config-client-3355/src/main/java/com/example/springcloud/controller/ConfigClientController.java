package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author echo
 * @date 2022年 01月 03日 15:55
 */
@RestController
@RefreshScope
public class ConfigClientController {

    /**
     * @Value("${config.info}")   Spring 的 @Value 注解
     *  消费   相当于配置了 config 后，就把 config 服务端里的变量引入进来了
     */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
