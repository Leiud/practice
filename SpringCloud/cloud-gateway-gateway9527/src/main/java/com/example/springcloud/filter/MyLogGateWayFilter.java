package com.example.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author echo
 * @date 2021年 12月 29日 20:06
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("come in MyLogGateWayFilter：" + new Date());
        // 获取 request 中的 uname 参数
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        // 合法性检验
        if(uname == null){
            log.info("用户名为 null，非法用户！！");
            // 设置响应，不被接受
            // 设置 response 状态码  因为在请求之前过滤的，so 就算是返回 NOT_FOUND 也不会返回错误页面
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            // 完成请求调用
            return exchange.getResponse().setComplete();
        }

        // 返回 chain.filter(exchange)，过滤链放行
        return chain.filter(exchange);
    }

    // 返回值是加载顺序，一般全局的都是第一位加载
    @Override
    public int getOrder() {
        // 返回值是过滤器的优先级，越小优先级越高（最小-2147483648，最大2147483648）
        return 0;
    }
}
