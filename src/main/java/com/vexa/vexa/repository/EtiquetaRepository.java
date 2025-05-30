package com.vexa.vexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vexa.vexa.model.Etiquetas; 

public interface EtiquetaRepository extends JpaRepository<Etiquetas, Long> {
    // No necesitas métodos extras si solo quieres listar todas las etiquetas
}


