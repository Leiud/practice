package com.example.springcloud.service.impl;

/**
 * @author echo
 * @date 2022年 01月 04日 17:34
 */
import com.example.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import javax.annotation.Resource;
import java.util.UUID;

/**
 * @EnableBinding(Source.class)
 * 定义消息的推送管道 output（Source 是 Spring 的）
 * 不是和 controller 打交道的 service，而是发送消息的推送服务类
 */
@EnableBinding(Source.class)    //定义消息的推送管道（Source是spring的）
public class IMessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 绑定器 MessageBuilder 是 Spring 的 integration.support.MessageBuilder
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial: " + serial);
        return null;
    }
}
