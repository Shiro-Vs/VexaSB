package com.vexa.vexa.controller;

import com.vexa.vexa.model.Tareas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TareaController {

    private List<Tareas> listatareas = new ArrayList<>();

    public TareaController() {
        listatareas.add(new Tareas(1L, "Diseño pagina", "Maquetar", "Frontend", "En progreso", "Alta",
                LocalDate.parse("2023-10-01"), LocalDate.parse("2023-10-15"), false));
        listatareas.add(new Tareas(2L, "Backend", "Crear API", "Backend", "Pendiente", "Media",
                LocalDate.parse("2023-10-02"), LocalDate.parse("2023-10-20"), false));
        listatareas.add(new Tareas(3L, "Base de datos", "Crear tablas", "Backend", "Pendiente", "Baja",
                LocalDate.parse("2023-10-03"), LocalDate.parse("2023-10-25"), false));
        listatareas.add(new Tareas(4L, "Pruebas", "Realizar pruebas", "QA", "Pendiente", "Media",
                LocalDate.parse("2023-10-04"), LocalDate.parse("2023-10-30"), false));
        listatareas.add(new Tareas(5L, "Documentación", "Crear documentación", "Documentación", "Pendiente", "Baja",
                LocalDate.parse("2023-10-05"), LocalDate.parse("2023-11-01"), false));
        listatareas.add(new Tareas(6L, "Reunión", "Reunión con el cliente", "Reuniones", "Pendiente", "Alta",
                LocalDate.parse("2023-10-06"), LocalDate.parse("2023-11-05"), false));
        listatareas.add(new Tareas(7L, "Despliegue", "Desplegar en producción", "Despliegue", "Pendiente", "Alta",
                LocalDate.parse("2023-10-07"), LocalDate.parse("2023-11-10"), false));
        listatareas.add(new Tareas(8L, "Mantenimiento", "Realizar mantenimiento", "Mantenimiento", "Pendiente", "Media",
                LocalDate.parse("2023-10-08"), LocalDate.parse("2023-11-15"), false));
        listatareas.add(new Tareas(9L, "Actualización", "Actualizar sistema", "Actualización", "Pendiente", "Baja",
                LocalDate.parse("2023-10-09"), LocalDate.parse("2023-11-20"), false));
    }

    @GetMapping("/inicio")
    public String mostrarTareas(Model model) {
        model.addAttribute("tareas", listatareas);
        return "inicio";
    }

}
