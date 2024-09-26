package com.prueba.customer_products_services.controller;

import com.prueba.customer_products_services.repository.entity.Movimientos;
import com.prueba.customer_products_services.service.MovimientosService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {


    private MovimientosService movimientosService;

    private RabbitTemplate rabbitTemplate;

    private String sendMessage(Movimientos movimientos) {
        rabbitTemplate.convertAndSend("myQueue", movimientos);
        return "Saldo enviado"+ movimientos.getSaldo();
    }

    public MovimientosController(MovimientosService movimientosService, RabbitTemplate rabbitTemplate) {
        this.movimientosService = movimientosService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public Movimientos create(@RequestBody Movimientos movimientos) {
        Movimientos newMovimiento = movimientosService.save(movimientos);
        sendMessage(movimientos);
        return newMovimiento;
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
