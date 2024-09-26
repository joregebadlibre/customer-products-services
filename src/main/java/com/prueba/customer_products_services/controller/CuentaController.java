package com.prueba.customer_products_services.controller;

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
    public Cuenta create(@RequestBody Cuenta cliente) {
        return cuentaService.save(cliente);
    }

    @PutMapping("/{id}")
    public Cuenta update(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        cuenta.setCuentaId(id);
        return cuentaService.update(cuenta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cuentaService.delete(id);
    }

}
