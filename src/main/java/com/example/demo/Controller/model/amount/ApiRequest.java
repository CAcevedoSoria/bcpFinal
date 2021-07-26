package com.example.demo.Controller.model.amount;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequest {

    private double monto;

    private String monedaOrigen;

    private String monedaDestino;


}
