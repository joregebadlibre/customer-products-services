package com.prueba.customer_products_services.service;

import com.prueba.customer_products_services.repository.entity.Movimientos;

public interface MovimientosService {

    Movimientos save(Movimientos movimientos);
    Movimientos update(Movimientos movimientos  );
    void delete(Long id);

}
