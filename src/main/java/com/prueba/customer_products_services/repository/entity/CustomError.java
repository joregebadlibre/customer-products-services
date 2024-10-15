package com.prueba.customer_products_services.repository.entity;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
    String codeErro;
    String messageError;
}
