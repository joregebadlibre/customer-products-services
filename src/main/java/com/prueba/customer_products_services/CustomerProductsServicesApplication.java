package com.prueba.customer_products_services;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.prueba.customer_products_services.repository")
public class CustomerProductsServicesApplication {

	public static void main(String[] args) {

//		Dotenv dotenv = Dotenv.load();
//		System.setProperty("DB_URL", dotenv.get("DB_URL"));
//		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
//		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
//		System.setProperty("SPRING_RABBITMQ_HOST", dotenv.get("SPRING_RABBITMQ_HOST"));
//		System.setProperty("SPRING_RABBITMQ_PORT", dotenv.get("SPRING_RABBITMQ_PORT"));

		SpringApplication.run(CustomerProductsServicesApplication.class, args);
	}

}
