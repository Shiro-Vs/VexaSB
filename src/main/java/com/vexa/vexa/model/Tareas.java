
package com.vexa.vexa.model;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tareas {
    private Long id;
    private String titulo;
    private String descripcion;
    private String etiqueta;
    private String estado;
    private String prioridad;
    private LocalDate fechaCreacion;
    private LocalDate fechaLimite;
    private boolean checkList;
}
