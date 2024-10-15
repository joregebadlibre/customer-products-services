package com.prueba.customer_products_services.controller;

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
    public Cuenta create(@RequestBody Cuenta cuenta) {

    if (cuenta.getNumeroCuenta() == null || cuenta.getEstado() == null || cuenta.getSaldoInicial() == null || cuenta.getSaldoActual() == null || cuenta.getTipoCuenta() == null) {
            throw new DatosInvalidosException("Datos de la cuenta son inválidos");
        }
        return cuentaService.save(cuenta);
    }

    @PutMapping("/{id}")
    public Cuenta update(@PathVariable Long id, @RequestBody Cuenta cuenta) {

        if (id == null || cuenta == null || !cuenta.getCuentaId().equals(id)) {
            throw new DatosInvalidosException("Datos de la cuenta no validos");
        }
        cuenta.setCuentaId(id);
        return cuentaService.update(cuenta);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        if (id == null) {
            throw new DatosInvalidosException("Id de cuenta inválido, intente más tarde");
        }

        cuentaService.delete(id);
    }

}
