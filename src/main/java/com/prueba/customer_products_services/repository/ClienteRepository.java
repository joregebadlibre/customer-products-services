package com.prueba.customer_products_services.repository;

import com.prueba.customer_products_services.repository.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}