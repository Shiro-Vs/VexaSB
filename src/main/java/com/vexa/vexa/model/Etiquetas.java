package com.vexa.vexa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "etiquetas")
public class Etiquetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiqueta") // Opcional si el nombre de la columna coincide
    private Long id_etiqueta;
    @Column(nullable = false)
    private String nombre;
    @Column(name = "cant_tareas")
    private int cant_tareas = 0;
    private String descripcion;
    private String color;
    private String icono;
}
