package com.prueba.customer_products_services.service;

import java.util.List;

import com.prueba.customer_products_services.repository.entity.Cuenta;

public interface CuentaService {

    Cuenta save(Cuenta cuenta);
    Cuenta update(Cuenta cuenta);
    void delete(Long id);
    Cuenta findById(Long id);
    List<Cuenta> fiCuentaByNumeroCuenta(String numeroCuenta);
}
