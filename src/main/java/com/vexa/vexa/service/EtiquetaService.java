package com.vexa.vexa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vexa.vexa.model.Etiquetas;           // Ajusta el paquete
import com.vexa.vexa.repository.EtiquetaRepository;  // Ajusta el paquete

@Service
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public EtiquetaService(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    public List<Etiquetas> listarEtiquetas() {
        return etiquetaRepository.findAll();
    }

    public void guardarEtiqueta(Etiquetas etiqueta) {
        etiquetaRepository.save(etiqueta);
    }
}

