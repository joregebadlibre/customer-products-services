package com.prueba.customer_products_services.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prueba.customer_products_services.exception.CuentaNoEncontradaException;
import com.prueba.customer_products_services.exception.DatosInvalidosException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CuentaNoEncontradaException.class)
    public ResponseEntity<String> manejarCuentaNoEncontrada(CuentaNoEncontradaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatosInvalidosException.class)
    public ResponseEntity<String> manejarDatosInvalidos(DatosInvalidosException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcionesGenerales(Exception ex) {
        return new ResponseEntity<>("Error inesperado, intente más tarde", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
