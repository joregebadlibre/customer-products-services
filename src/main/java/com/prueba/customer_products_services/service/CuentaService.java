package com.prueba.customer_products_services.service;

import com.prueba.customer_products_services.exception.CuentaException;
import java.util.List;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import java.util.List;

public interface CuentaService {

    Cuenta save(Cuenta cuenta) throws CuentaException;
    Cuenta update(Cuenta cuenta) throws CuentaException;
    void delete(Long id) throws CuentaException;
    Cuenta findById(Long id) throws CuentaException;
    List<Cuenta> fiCuentaByNumeroCuenta(String numeroCuenta);
}
