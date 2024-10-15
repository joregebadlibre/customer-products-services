package com.prueba.customer_products_services.service.impl;

import com.prueba.customer_products_services.repository.CuentaRepository;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.service.CuentaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;
    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta update(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void delete(Long id) {
        cuentaRepository.deleteById(id);
    }

    @Override
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cuenta> fiCuentaByNumeroCuenta(String numeroCuenta) {

        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            return null;
        }
        return cuentaRepository.findByNumeroCuenta(numeroCuenta);
    }
}
