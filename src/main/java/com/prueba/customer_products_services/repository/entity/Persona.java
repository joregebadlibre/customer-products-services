package com.prueba.customer_products_services.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personaId;

    @Column(nullable = false)
    private String nombre;

    private String genero;
    private Integer edad;

    @Column(unique = true)
    private String identificacion;

    private String direccion;
    private String telefono;

}