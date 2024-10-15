package com.prueba.customer_products_services.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReporteMovimientos {
    Cuenta cuenta;
    List<Movimientos> movimientos;
}
