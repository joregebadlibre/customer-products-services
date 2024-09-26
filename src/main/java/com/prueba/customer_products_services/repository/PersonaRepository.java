package com.prueba.customer_products_services.repository;

import com.prueba.customer_products_services.repository.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {


}