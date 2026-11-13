package com.foodcatalogue.gateway_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
                .authorizeExchange(
                    ex -> ex
                    .pathMatchers("/actuator/health/**", "/actuator/info").permitAll()
                    .pathMatchers("/swagger-ui.html", "/swagger-ui/**", "/webjars/**", "/v3/api-docs/**", "/*/v3/api-docs/**").permitAll()
                    .pathMatchers(HttpMethod.POST, "/auth-service/auth/login", "/auth-service/users").permitAll()
                    .pathMatchers(HttpMethod.GET, "/auth-service/.well-known/**").permitAll()
                    .pathMatchers(HttpMethod.POST, "/order-service/orders/create").permitAll()
                    .pathMatchers(HttpMethod.GET, "/products-service/**", "/establishment-service/**", "/review-service/**").permitAll()
                    .pathMatchers("/payment-service/webhooks/**", "/notification-service/webhooks/**").permitAll()
                    .pathMatchers("/actuator/**").hasRole("ADMIN")
                    .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()))
                .build();
    }
}
