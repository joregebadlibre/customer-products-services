package com.prueba.customer_products_services.service.impl;

import com.prueba.customer_products_services.exception.CuentaException;
import com.prueba.customer_products_services.exception.HistoricoException;
import com.prueba.customer_products_services.exception.MovimientoException;
import com.prueba.customer_products_services.repository.CuentaRepository;
import com.prueba.customer_products_services.repository.HistoricoRepository;
import com.prueba.customer_products_services.repository.MovimientosRepository;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.repository.entity.Historico;
import com.prueba.customer_products_services.repository.entity.Movimientos;
import com.prueba.customer_products_services.service.HistoricoService;
import com.prueba.customer_products_services.service.MovimientosService;
import com.prueba.customer_products_services.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientosServiceImpl implements MovimientosService {

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private HistoricoService historicoService;

    @Override
    public Movimientos save(Movimientos movimientos) throws MovimientoException, HistoricoException {

        Optional<Cuenta> cuenta = cuentaRepository.findById(movimientos.getCuenta().getCuentaId());

        if (cuenta.isPresent()) {
            BigDecimal saldo = BigDecimal.ZERO;
            saldo = saldo.add( cuenta.get().getSaldoActual());

            if (movimientos.getTipoMovimiento().equalsIgnoreCase(Constants.MOVIMIENTO_TIPO))
            {
                BigDecimal sumaSaldo = saldo.add(movimientos.getValor());
                movimientos.setSaldo(sumaSaldo);
                Cuenta nuevosaldo = cuenta.get();
                nuevosaldo.setSaldoActual(sumaSaldo);
                cuentaRepository.save(cuenta.get());
                movimientos.setSaldo(sumaSaldo);
                movimientosRepository.save(movimientos);
            }
            else
            {
                //int comparisonResult = saldo.compareTo(movimientos.getValor());
                if (saldo.compareTo(movimientos.getValor()) >= 0 ) {
                    saldo = saldo.subtract(movimientos.getValor());
                    movimientos.setSaldo(saldo);
                    Cuenta nuevosaldo = cuenta.get();
                    nuevosaldo.setSaldoActual(saldo);
                    cuentaRepository.save(cuenta.get());
                    movimientos.setSaldo(saldo);
                    movimientosRepository.save(movimientos);
                }
                else
                {
                    throw new MovimientoException(Constants.MOVIMIENTO_INSUFICIENTE_SALDO);
                }
            }
        }
        guardarHistorico(movimientos);
        return movimientos;
    }


    private void guardarHistorico(Movimientos movimientos) throws HistoricoException {
            Historico historico = new Historico();
            historico.setMovimientoId(movimientos.getMovimientoId().intValue());
            historico.setFecha(movimientos.getFecha());
            historico.setSaldo(movimientos.getSaldo());
            historico.setValor(movimientos.getValor());
            historico.setTipoMovimiento(movimientos.getTipoMovimiento());
            historico.setCuentaId(movimientos.getCuenta().getCuentaId().intValue());
            historicoService.save(historico);
    }

    @Override
    public void delete(Long id) {
        movimientosRepository.deleteById(id);
    }

    @Override
    public List<Movimientos> findByFechaBetween(Date startDate, Date endDate) throws MovimientoException {
        return movimientosRepository.findByFechaBetween(startDate, endDate);
    }

    @Override
    public List<Movimientos> findByCuenta_CuentaIdAndFechaBetween(Long cuentaId, Date fechaInicio, Date fechaFin) throws MovimientoException, HistoricoException {
        return movimientosRepository.findByCuenta_CuentaIdAndFechaBetween(cuentaId, fechaInicio, fechaFin);
    }
}
