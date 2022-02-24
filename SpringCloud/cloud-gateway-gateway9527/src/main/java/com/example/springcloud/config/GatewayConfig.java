package com.example.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author echo
 * @date 2021年 12月 29日 16:45
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // id
        routes.route("path_route_guonei",
                // 访问 http://localhost:9527/guonei
                r -> r.path("/guonei")
                        // 就会转发到 http://news.baidu.com/guonei
                        .uri("http://news.baidu.com/guonei"));
        // id
        routes.route("path_route_guoji",
                // 访问 http://localhost:9527/guoji
                r -> r.path("/guoji")
                        // 就会转发到 http://news.baidu.com/guonji
                        .uri("http://news.baidu.com/guoji"));

        return routes.build();
    }
}
