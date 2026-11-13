package com.foodcatalogue.gateway_service.security;

import java.net.InetSocketAddress;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.support.ipresolver.XForwardedRemoteAddressResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class RateLimitConfig {

    private final XForwardedRemoteAddressResolver remoteAddressResolver = XForwardedRemoteAddressResolver.maxTrustedIndex(1);

    @Bean
    public KeyResolver clientIpKeyResolver() {
        return exchange -> {
            InetSocketAddress address = remoteAddressResolver.resolve(exchange);
            return Mono.justOrEmpty(address)
                .map(addr -> addr.getAddress() != null ? addr.getAddress().getHostAddress() : addr.getHostString());
        };
    }
}
