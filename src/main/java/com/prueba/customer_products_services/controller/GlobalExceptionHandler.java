package com.prueba.customer_products_services.controller;


import com.prueba.customer_products_services.exception.CuentaException;
import com.prueba.customer_products_services.exception.CuentaNotFoundException;
import com.prueba.customer_products_services.exception.MovimientoException;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.repository.entity.CustomError;
import com.prueba.customer_products_services.repository.entity.Movimientos;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static HttpHeaders headers = new HttpHeaders();

    @ExceptionHandler(CuentaNotFoundException.class)
    public ResponseEntity<Cuenta> handlePersonaNotFoundException(CuentaNotFoundException ex) {
        com.prueba.customer_products_services.repository.entity.CustomError error = com.prueba.customer_products_services.repository.entity.CustomError.builder()
                .codeErro("404")
                .messageError(ex.getMessage())
                .build();
        Cuenta p = new Cuenta();
        p.setError(error);
        headers.add("Content-Type", "application/json");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(p);
    }


    @ExceptionHandler(CuentaException.class)
    public ResponseEntity<Cuenta> handleGeneralException(CuentaException ex) {
        CustomError error = CustomError.builder()
                .codeErro("999")
                .messageError(ex.getMessage())
                .build();
        Cuenta p = new Cuenta();
        p.setError(error);
        headers.add("Content-Type", "application/json");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(p);
    }

    @ExceptionHandler(MovimientoException.class)
    public ResponseEntity<Movimientos> handleGeneralException(MovimientoException ex) {
        CustomError error = CustomError.builder()
                .codeErro("999")
                .messageError(ex.getMessage())
                .build();
        Movimientos c = new Movimientos();
        c.setError(error);
        headers.add("Content-Type", "application/json");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(c);
    }
}