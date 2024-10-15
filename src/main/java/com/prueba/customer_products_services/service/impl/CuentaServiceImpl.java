package com.prueba.customer_products_services.service.impl;

import com.prueba.customer_products_services.exception.CuentaException;
import com.prueba.customer_products_services.repository.CuentaRepository;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.service.CuentaService;
import com.prueba.customer_products_services.utils.Constants;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Cuenta save(Cuenta cuenta) throws CuentaException {
        try {
            return cuentaRepository.save(cuenta);
        }
        catch (Exception ex) {
            throw new CuentaException(Constants.ERROR_SAVE);
        }
    }

    @Override
    public Cuenta update(Cuenta cuenta) throws CuentaException {
        try
        {
        return cuentaRepository.save(cuenta);
        }
        catch (Exception ex) {
            throw new CuentaException(Constants.ERROR_UPDATE);
        }
    }

    @Override
    public void delete(Long id) throws CuentaException {
        try
        {
        cuentaRepository.deleteById(id);
        }
        catch (Exception ex) {
            throw new CuentaException(Constants.ERROR_DELETE);
        }
    }

    @Override
    public Cuenta findById(Long id) throws CuentaException {
        try
        {
            return cuentaRepository.findById(id).get();
        }
        catch (Exception ex) {
            throw new CuentaException(Constants.ERROR_FIND);
        }
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
