package com.prueba.customer_products_services.controller;

import com.prueba.customer_products_services.exception.CuentaException;
import com.prueba.customer_products_services.exception.HistoricoException;
import com.prueba.customer_products_services.exception.MovimientoException;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.repository.entity.Movimientos;
import com.prueba.customer_products_services.repository.entity.ReporteMovimientos;
import com.prueba.customer_products_services.service.CuentaService;
import com.prueba.customer_products_services.service.MovimientosService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {


    private MovimientosService movimientosService;
    private CuentaService cuentaService;

    public MovimientosController(MovimientosService movimientosService, CuentaService cuentaService) {
        this.movimientosService = movimientosService;
        this.cuentaService = cuentaService;
    }

    @PostMapping
    public Movimientos create(@RequestBody Movimientos movimientos) throws MovimientoException, HistoricoException {
        Cuenta cuenta;
        List<Movimientos> movimientosList;
        Movimientos newMovimiento;
        try {
            cuenta = cuentaService.findById(movimientos.getCuenta().getCuentaId());
            newMovimiento = movimientosService.save(movimientos);
        }
        catch (Exception e) {
            throw new MovimientoException("Cuenta no encontrada");
        }
        return newMovimiento;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movimientosService.delete(id);
    }

    @GetMapping("/{startDate}/{endDate}")
    public List<Movimientos> findByFechaBetween(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) throws MovimientoException {
        return movimientosService.findByFechaBetween(startDate, endDate);
    }

    @GetMapping("/{startDate}/{endDate}/{cuentaId}")
    public ReporteMovimientos findByCuenta_CuentaIdAndFechaBetween(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                   @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, @PathVariable Long cuentaId) throws MovimientoException, HistoricoException, CuentaException {

        Cuenta cuenta;
        List<Movimientos> movimientosList;
        try {
            cuenta = cuentaService.findById(cuentaId);
        }
        catch (Exception e) {
            throw new MovimientoException("Cuenta no encontrada");
        }

        try {
            movimientosList = movimientosService.findByCuenta_CuentaIdAndFechaBetween(cuentaId, startDate, endDate);
        }
        catch (Exception e) {
            throw new MovimientoException("Movimientos no encontrados");
        }

        ReporteMovimientos reporteMovimientos = new ReporteMovimientos();
        reporteMovimientos.setCuenta(cuenta);
        reporteMovimientos.setMovimientos(movimientosList);
        return reporteMovimientos;
    }
}
