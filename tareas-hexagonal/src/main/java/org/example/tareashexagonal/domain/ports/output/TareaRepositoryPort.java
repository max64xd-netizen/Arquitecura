package org.example.tareashexagonal.domain.ports.output;

import org.example.tareashexagonal.domain.model.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaRepositoryPort {

    Tarea guardar(Tarea tarea);

    List<Tarea> listar();

    Optional<Tarea> buscarPorId(Long id);
    List<Tarea> listarPendientes();

    void eliminar(Long id);
}