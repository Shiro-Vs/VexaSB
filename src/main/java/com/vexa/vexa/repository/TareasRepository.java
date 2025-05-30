package com.vexa.vexa.repository;

import com.vexa.vexa.model.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareasRepository extends JpaRepository<Tareas, Long> {
    // Aquí puedes definir métodos personalizados si los necesitas
}