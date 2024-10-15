package com.prueba.customer_products_services.repository;

import com.prueba.customer_products_services.repository.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query("SELECT c FROM cuenta c WHERE c.numero_cuenta = :numeroCuenta")
    Optional<Cuenta> findByNumeroCuenta(@Param("numeroCuenta") String numeroCuenta);
}