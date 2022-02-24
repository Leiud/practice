package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author echo
 * @date 2021年 12月 07日 16:04
 *
 * @EnableEurekaServer 表示此项目是 eureka 的服务注册中心
 * exclude = DataSourceAutoConfiguration.class：启动时不启用 DataSource 的自动配置检查
 */
@EnableEurekaServer
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EurekaMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
