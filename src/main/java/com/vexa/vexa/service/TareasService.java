package com.vexa.vexa.service;

import com.vexa.vexa.model.Tareas;
import com.vexa.vexa.repository.TareasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareasService {

    private final TareasRepository tareasRepository;

    public TareasService(TareasRepository tareasRepository) {
        this.tareasRepository = tareasRepository;
    }

    public List<Tareas> obtenerTodasLasTareas() {
        return tareasRepository.findAll();
    }

    public void guardarTarea(Tareas tarea) {
        tareasRepository.save(tarea);
    }

    public void eliminarPorId(Long id) {
        tareasRepository.deleteById(id);
    }
    // Puedes agregar métodos para eliminar, actualizar, buscar, etc.
}
