package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author echo
 * @date 2021年 12月 09日 10:35
 * @EnableDiscoveryClient 该注解用于想使用 Consul 或者 ZooKeeper 作为注册中心时注册服务，
 * 以后用这个就可以了，不用 eureka 了
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
