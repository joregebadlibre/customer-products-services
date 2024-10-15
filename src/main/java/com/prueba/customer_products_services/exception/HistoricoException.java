package com.prueba.customer_products_services.exception;

public class HistoricoException extends Exception {
    public HistoricoException(String mensaje) {
        super(mensaje);
    }

    public HistoricoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
