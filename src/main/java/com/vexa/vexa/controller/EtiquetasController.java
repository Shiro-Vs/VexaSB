package com.vexa.vexa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vexa.vexa.model.Etiquetas;

@Controller
public class EtiquetasController {

    private List<Etiquetas> listaEtiquetas = new ArrayList<>();

    public EtiquetasController() {
        listaEtiquetas.add(new Etiquetas(1L, "Urgente", "Tareas urgentes", "red"));
        listaEtiquetas.add(new Etiquetas(2L, "Importante", "Tareas importantes", "blue"));
        listaEtiquetas.add(new Etiquetas(3L, "Opcional", "Tareas opcionales", "green"));
        listaEtiquetas.add(new Etiquetas(4L, "Reuniones", "Tareas de reuniones", "yellow"));
        listaEtiquetas.add(new Etiquetas(5L, "Documentación", "Tareas de documentación", "purple"));
        listaEtiquetas.add(new Etiquetas(6L, "Despliegue", "Tareas de despliegue", "orange"));
        listaEtiquetas.add(new Etiquetas(7L, "Mantenimiento", "Tareas de mantenimiento", "pink"));
    }

    @GetMapping("/Etiquetas")
    public String mostrarEtiquetas(Model model) {
        model.addAttribute("etiquetas", listaEtiquetas);
        return "etiquetas";
    }

    @PostMapping("/eliminarEtiqueta/{id}")
    public String eliminarEtiqueta(@PathVariable Long id) {
        listaEtiquetas.removeIf(e -> e.getId().equals(id));
        return "redirect:/Etiquetas";
    }

}
