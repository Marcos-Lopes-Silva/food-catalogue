package com.foodcatalogue.gateway_service.security;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import reactor.core.publisher.Mono;

@Component
public class UserHeaderFilter implements GlobalFilter, Ordered {

    public static final String USER_ID_HEADER = "X-User-Id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest sanitized = exchange.getRequest().mutate()
            .headers(headers -> headers.remove(USER_ID_HEADER))
            .build();
        ServerWebExchange sanitizedExchange = exchange.mutate().request(sanitized).build();

        return ReactiveSecurityContextHolder.getContext()
        .map(securityContext -> securityContext.getAuthentication())
        .filter(JwtAuthenticationToken.class::isInstance)
        .cast(JwtAuthenticationToken.class)
        .map(auth -> {
            String userId = auth.getToken().getSubject();
            ServerHttpRequest req = sanitizedExchange.getRequest().mutate()
                .header(USER_ID_HEADER, userId)
                .build();
            return sanitizedExchange.mutate().request(req).build();
        })
        .defaultIfEmpty(sanitizedExchange)
        .flatMap(chain::filter);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

}
