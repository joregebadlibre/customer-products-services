package com.prueba.customer_products_services.repository;
import com.prueba.customer_products_services.repository.entity.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {

    List<Movimientos> findByFechaBetween(Date startDate, Date endDate);

    List<Movimientos> findByCuenta_CuentaIdAndFechaBetween(Long cuentaId, Date fechaInicio, Date fechaFin);

}