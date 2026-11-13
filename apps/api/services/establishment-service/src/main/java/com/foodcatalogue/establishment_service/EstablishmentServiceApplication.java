package com.foodcatalogue.establishment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition (servers = {
		@Server(url = "/establishment-service", description = "Default Server URL") })
@EnableCaching
@EnableFeignClients
@SpringBootApplication
public class EstablishmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstablishmentServiceApplication.class, args);
	}

}
