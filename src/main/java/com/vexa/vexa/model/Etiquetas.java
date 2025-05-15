package com.vexa.vexa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Etiquetas {

    private Long id;
    private String nombre;
    private String descripcion;
    private String color;
    
}
