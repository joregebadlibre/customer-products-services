package com.prueba.customer_products_services.service;

import com.prueba.customer_products_services.exception.HistoricoException;
import com.prueba.customer_products_services.exception.MovimientoException;
import com.prueba.customer_products_services.repository.entity.Movimientos;

import java.util.Date;
import java.util.List;

public interface MovimientosService {

    Movimientos save(Movimientos movimientos) throws MovimientoException, HistoricoException;
    void delete(Long id);

    List<Movimientos> findByFechaBetween(Date startDate, Date endDate)throws MovimientoException;

    List<Movimientos> findByCuenta_CuentaIdAndFechaBetween(Long cuentaId, Date fechaInicio, Date fechaFin) throws MovimientoException, HistoricoException;

}
