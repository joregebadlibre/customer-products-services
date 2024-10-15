package com.prueba.customer_products_services.controller;

import com.prueba.customer_products_services.exception.CuentaException;
import com.prueba.customer_products_services.exception.DatosInvalidosException;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.service.CuentaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {


    private CuentaService cuentaService;

    public CuentaController(CuentaService clienteService) {
        this.cuentaService = clienteService;
    }

    @PostMapping
    public Cuenta create(@RequestBody Cuenta cliente) throws CuentaException {
        return cuentaService.save(cliente);
    }

    @PutMapping("/{id}")
    public Cuenta update(@PathVariable Long id, @RequestBody Cuenta cuenta) throws CuentaException {
    if (cuenta.getNumeroCuenta() == null || cuenta.getEstado() == null || cuenta.getSaldoInicial() == null || cuenta.getSaldoActual() == null || cuenta.getTipoCuenta() == null) {
            throw new DatosInvalidosException("Datos de la cuenta son inválidos");
        }
        cuenta.setCuentaId(id);
        return cuentaService.save(cuenta);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws CuentaException {
        if (id == null) {
            throw new DatosInvalidosException("Id de cuenta inválido, intente más tarde");
        }
        cuentaService.delete(id);
    }

}
