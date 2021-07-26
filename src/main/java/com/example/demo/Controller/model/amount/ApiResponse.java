package com.example.demo.Controller.model.amount;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private double monto;

    private double montoFinal;

    private String monedaOrigen;

    private String monedaDestino;

    private double tipoCambio;
}
