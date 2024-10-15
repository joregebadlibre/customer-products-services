package com.prueba.customer_products_services.exception;

public class CuentaException extends Exception {
    public CuentaException(String mensaje) {
        super(mensaje);
    }

    public CuentaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
