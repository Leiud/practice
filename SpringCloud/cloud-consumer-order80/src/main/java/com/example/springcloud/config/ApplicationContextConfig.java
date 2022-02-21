package com.example.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    /**
     * 往容器中添加一个 RestTemplate
     * RestTemplate 提供了多种便捷访问远程 http 访问的方法，
     * 是一种简单便捷的访问 restful 服务模板类，
     * 是 Spring 提供的用于访问 Rest 服务的客户端模板工具集，实现 80 到 8001 的远程调用。
     * 使用：
     * 使用 restTemplate 访问 restful 接口非常的简单粗暴，
     * （url、requestMap、ResponseBean.class）这三个参数分别代表
     * REST 请求地址、请求参数、HTTP 响应转换被转换成的对象类型。
     *
     *
     *
     * @Bean   用注解的方式依赖注入 RestTemplate，在容器里就有 RestTemplate 对象
     * @LoadBalanced 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡能力
     * @return
     */
    @Bean
    // @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
