package com.prueba.customer_products_services.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimientoId;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuentaId")
    private Cuenta cuenta;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String tipoMovimiento;
    private BigDecimal valor;
    private BigDecimal saldo;

}