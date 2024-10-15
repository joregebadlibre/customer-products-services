package com.prueba.customer_products_services.service;

import com.prueba.customer_products_services.exception.CuentaException;
import com.prueba.customer_products_services.exception.HistoricoException;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.repository.entity.Historico;

public interface HistoricoService {

    Historico save(Historico historico) throws HistoricoException;
}
