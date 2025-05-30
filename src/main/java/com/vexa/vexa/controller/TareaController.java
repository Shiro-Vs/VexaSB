package com.vexa.vexa.controller;

import com.vexa.vexa.model.Tareas;
import com.vexa.vexa.model.Usuario;
import com.vexa.vexa.repository.UsuarioRepository;
import com.vexa.vexa.service.TareasService;
import com.vexa.vexa.service.EtiquetaService;
import com.vexa.vexa.model.Etiquetas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TareaController {

        private final TareasService tareasService;
        private final UsuarioRepository usuarioRepository;
        private final EtiquetaService etiquetaService;

        public TareaController(TareasService tareasService, UsuarioRepository usuarioRepository,
                        EtiquetaService etiquetaService) {
                this.tareasService = tareasService;
                this.usuarioRepository = usuarioRepository;
                this.etiquetaService = etiquetaService;
        }

        @GetMapping("/inicio")
        public String mostrarTareas(Model model) {
                List<Tareas> listaTareas = tareasService.obtenerTodasLasTareas();
                List<Etiquetas> etiquetas = etiquetaService.listarEtiquetas(); // 👈 etiquetas de la BDD

                model.addAttribute("tareas", listaTareas);
                model.addAttribute("etiquetas", etiquetas); // 👈 envías al HTML
                model.addAttribute("tarea", new Tareas()); // para el formulario
                return "inicio"; // Asegúrate de que el modal esté en inicio.html
        }

        @PostMapping("/tareas")
        public String guardarTarea(@ModelAttribute Tareas tarea) {
                Usuario usuario = usuarioRepository.findById(1L)
                                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")); // usa el ID correcto
                tarea.setUsuario(usuario); // ✔️ usuario gestionado por JPA

                // 🔍 Verifica si el usuario se asignó correctamente
                System.out.println("Usuario asignado: " + tarea.getUsuario());
                System.out.println("ID del usuario: " + tarea.getUsuario().getUsuario_id());
                tarea.setEstado("pendiente");
                tarea.setCheckList(false);
                tareasService.guardarTarea(tarea);
                return "redirect:/inicio";
        }

        @PostMapping("/tareas/eliminar")
        public String eliminarTarea(@RequestParam("id") Long id) {
                tareasService.eliminarPorId(id);
                return "redirect:/inicio";
        }

}
