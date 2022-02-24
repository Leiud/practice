package com.example.springcloud.controller;

/**
 * @author echo
 * @date 2022年 01月 04日 20:05
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

@EnableBinding(Sink.class)
@Controller
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 监听 消费者
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者2号------>收到的消息：" + message.getPayload() + "\t port：" + serverPort);
    }
}
