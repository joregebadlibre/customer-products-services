package com.prueba.customer_products_services.service;

import com.prueba.customer_products_services.exception.CuentaException;
import com.prueba.customer_products_services.repository.entity.Cuenta;

import java.util.Optional;

public interface CuentaService {

    Cuenta save(Cuenta cuenta) throws CuentaException;
    Cuenta update(Cuenta cuenta) throws CuentaException;
    void delete(Long id) throws CuentaException;
    Cuenta findById(Long id) throws CuentaException;

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta) throws CuentaException;
}
