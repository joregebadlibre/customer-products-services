package com.prueba.customer_products_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.prueba.customer_products_services.repository")
public class CustomerProductsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProductsServicesApplication.class, args);
	}

}
