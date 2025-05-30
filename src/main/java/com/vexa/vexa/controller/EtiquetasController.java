package com.vexa.vexa.controller;

import com.vexa.vexa.model.Etiquetas;
import com.vexa.vexa.service.EtiquetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EtiquetasController {

    @Autowired
    private EtiquetaService etiquetaService;

    @GetMapping("/etiquetas")
    public String mostrarEtiquetas(Model model) {
        List<Etiquetas> etiquetas = etiquetaService.listarEtiquetas();
        model.addAttribute("etiquetas", etiquetas);
        return "etiquetas";
    }

    @PostMapping("/etiquetas")
    public String guardarEtiqueta(@ModelAttribute Etiquetas etiqueta) {
        etiquetaService.guardarEtiqueta(etiqueta);
        return "redirect:/etiquetas";
    }
}
