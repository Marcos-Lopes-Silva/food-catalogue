package com.foodcatalogue.auth_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import com.foodcatalogue.auth_service.models.Role;
import com.foodcatalogue.auth_service.models.User;
import com.foodcatalogue.auth_service.repositories.UserRepository;

@Configuration
public class DataInitializer {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    @Value("${application.bootstrap.admin.email:}")
    private String adminEmail;

    @Value("${application.bootstrap.admin.password:}")
    private String adminPassword;

    @Bean
    CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!StringUtils.hasText(adminEmail) || !StringUtils.hasText(adminPassword)) {
                log.info("Admin inicial não configurado (AUTH_ADMIN_EMAIL/AUTH_ADMIN_PASSWORD); seed ignorado");
                return;
            }

            if (userRepository.existsByEmail(adminEmail)) {
                return;
            }

            User admin = User.builder()
                .email(adminEmail)
                .name("ADMIN")
                .role(Role.ROLE_ADMIN)
                .password(passwordEncoder.encode(adminPassword))
                .build();

            userRepository.save(admin);
        };
    }
}
