package com.prueba.customer_products_services.service.impl;

import com.prueba.customer_products_services.exception.CuentaException;
import com.prueba.customer_products_services.exception.HistoricoException;
import com.prueba.customer_products_services.repository.CuentaRepository;
import com.prueba.customer_products_services.repository.HistoricoRepository;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.repository.entity.Historico;
import com.prueba.customer_products_services.service.CuentaService;
import com.prueba.customer_products_services.service.HistoricoService;
import com.prueba.customer_products_services.utils.Constants;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoServiceImpl implements HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;
    @Override
    public Historico save(Historico historico) throws HistoricoException {
        try {
            return historicoRepository.save(historico);
        }
        catch (Exception ex) {
            throw new HistoricoException(Constants.ERROR_SAVE);
        }
    }
}
