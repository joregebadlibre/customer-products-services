package com.prueba.customer_products_services.service.impl;

import com.prueba.customer_products_services.repository.CuentaRepository;
import com.prueba.customer_products_services.repository.HistoricoRepository;
import com.prueba.customer_products_services.repository.MovimientosRepository;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.repository.entity.Historico;
import com.prueba.customer_products_services.repository.entity.Movimientos;
import com.prueba.customer_products_services.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class MovimientosServiceImpl implements MovimientosService {

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private HistoricoRepository historicoRepository;

    @Override
    public Movimientos save(Movimientos movimientos) {

        Optional<Cuenta> cuenta = cuentaRepository.findById(movimientos.getCuenta().getCuentaId());

        if (cuenta.isPresent()) {
            BigDecimal saldo = BigDecimal.ZERO;
            saldo = saldo.add( cuenta.get().getSaldoActual());

            if (movimientos.getTipoMovimiento().toLowerCase().equals("deposito"))
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
                int comparisonResult = saldo.compareTo(movimientos.getValor());

                if (comparisonResult >= 0 ) {
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
                    //error no se puede retirar mas de lo que tiene de saldo
                }
            }

        }

        guardarHistorico(movimientos);
        return movimientos;
    }


    private void guardarHistorico(Movimientos movimientos)
    {
        try {
            Historico historico = new Historico();
            historico.setMovimientoId(movimientos.getMovimientoId().intValue());
            historico.setFecha(movimientos.getFecha());
            historico.setSaldo(movimientos.getSaldo());
            historico.setValor(movimientos.getValor());
            historico.setTipoMovimiento(movimientos.getTipoMovimiento());
            historico.setCuentaId(movimientos.getCuenta().getCuentaId().intValue());
            historicoRepository.save(historico);
        }catch (Exception ex)
        {

        }
    }
    @Override
    public Movimientos update(Movimientos movimientos) {
        return movimientosRepository.save(movimientos);
    }

    @Override
    public void delete(Long id) {
        movimientosRepository.deleteById(id);
    }

}
