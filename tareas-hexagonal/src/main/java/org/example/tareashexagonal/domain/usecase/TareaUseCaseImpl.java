package org.example.tareashexagonal.domain.usecase;

import org.example.tareashexagonal.domain.model.Tarea;
import org.example.tareashexagonal.domain.ports.input.TareaUseCase;
import org.example.tareashexagonal.domain.ports.output.TareaRepositoryPort; 

import java.util.List; 

public class TareaUseCaseImpl implements TareaUseCase {

    private final TareaRepositoryPort repository;

    public TareaUseCaseImpl(TareaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Tarea crearTarea(String titulo, String descripcion) {

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }

        Tarea tarea = new Tarea(null, titulo, descripcion, false);
        return repository.guardar(tarea);
    }

    @Override
    public List<Tarea> listarTareas() {
        return repository.listar();
    }

    @Override
    public Tarea completarTarea(Long id) {
        Tarea tarea = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        tarea.completar();
        return repository.guardar(tarea);
    }

    // obtener tareas pendientes
    @Override
    public List<Tarea> obtenerPendientes() {
        return repository.listar().stream()
                .filter(t -> !t.isCompletada())
                .toList();
    }

    // eliminar tarea
    @Override
    public void eliminarTarea(Long id) {
        repository.eliminar(id);
    }
}
