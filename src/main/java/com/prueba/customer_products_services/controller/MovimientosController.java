package com.prueba.customer_products_services.controller;

import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.repository.entity.Movimientos;
import com.prueba.customer_products_services.service.CuentaService;
import com.prueba.customer_products_services.service.MovimientosService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {


    private MovimientosService movimientosService;

    public MovimientosController(MovimientosService movimientosService) {
        this.movimientosService = movimientosService;
    }

    @PostMapping
    public Movimientos create(@RequestBody Movimientos movimientos) {
        return movimientosService.save(movimientos);
    }

    @PutMapping("/{id}")
    public Movimientos update(@PathVariable Long id, @RequestBody Movimientos movimientos) {
        movimientos.setMovimientoId(id);
        return movimientosService.update(movimientos);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movimientosService.delete(id);
    }

}
