package com.example.springsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springsecurity.mapper")
public class CustomerAuthenticationMain {

    public static void main(String[] args) {
        SpringApplication.run(CustomerAuthenticationMain.class, args);
    }
}
