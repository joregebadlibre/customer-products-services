package com.prueba.customer_products_services.repository;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    List<Cuenta> findByNumeroCuenta(String numeroCuenta);
}