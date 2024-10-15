package com.prueba.customer_products_services.exception;

public class MovimientoException extends Exception {
    public MovimientoException(String mensaje) {
        super(mensaje);
    }

    public MovimientoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
