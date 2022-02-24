package com.example.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QuickStartMain {

    public static void main(String[] args) {
//        SpringApplication.run(QuickStartMain.class, args);

        // 加断点调试，查看 SpringSecurity 中的过滤器链
        ConfigurableApplicationContext run = SpringApplication.run(QuickStartMain.class, args);
        // 在此处加断点
        System.out.println("断点调试");

    }
}
