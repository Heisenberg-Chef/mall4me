package com.mall4j.cloud.gateway.component;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(exchange.getRequest());
        System.out.println(exchange.getAttributes());
        System.out.println(exchange.getResponse());
        return chain.filter(exchange);
    }

    //    0 表示最高优先级
    @Override
    public int getOrder() {
        return 0;
    }
}
