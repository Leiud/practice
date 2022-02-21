package com.example.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author echo
 * @date 2022年 01月 08日 16:10
 */

/**
 *  nacos 底层也是 ribbon，注入 RestTemplate
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * @LoadBalanced   负载均衡
     * RestTemplate 结合 Ribbon 做负载均衡一定要加 @LoadBalanced
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
