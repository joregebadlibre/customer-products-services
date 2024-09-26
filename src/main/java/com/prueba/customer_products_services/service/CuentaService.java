package com.prueba.customer_products_services.service;

import com.prueba.customer_products_services.repository.entity.Cuenta;

public interface CuentaService {

    Cuenta save(Cuenta cuenta);
    Cuenta update(Cuenta cuenta);
    void delete(Long id);
}
