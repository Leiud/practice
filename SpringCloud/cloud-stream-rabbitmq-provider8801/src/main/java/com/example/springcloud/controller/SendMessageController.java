package com.example.springcloud.controller;

import com.example.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author echo
 * @date 2022年 01月 04日 17:38
 */
@RestController
public class SendMessageController {

    /**
     * 自己的类
     */
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        // 自己定义的方法，但是里面调用了 MessageChannel.send() 方法
        return iMessageProvider.send();
    }
}
