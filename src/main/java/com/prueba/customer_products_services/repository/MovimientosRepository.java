package com.prueba.customer_products_services.repository;
import com.prueba.customer_products_services.repository.entity.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {
}