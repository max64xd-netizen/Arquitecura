package org.example.tareashexagonal.infrastructure.adapters;

import org.example.tareashexagonal.domain.model.Tarea;
import org.example.tareashexagonal.domain.ports.output.TareaRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TareaRepositoryAdapter implements TareaRepositoryPort {

    private final Map<Long, Tarea> baseDatos = new HashMap<>();
    private Long contador = 1L;

    @Override
    public Tarea guardar(Tarea tarea) {
        if (tarea.getId() == null) {
            tarea = new Tarea(contador++, tarea.getTitulo(), tarea.getDescripcion(), tarea.isCompletada());
        }
        baseDatos.put(tarea.getId(), tarea);
        return tarea;
    }

    @Override
    public List<Tarea> listar() {
        return new ArrayList<>(baseDatos.values());
    }

    @Override
    public Optional<Tarea> buscarPorId(Long id) {
        return Optional.ofNullable(baseDatos.get(id));
    }

    @Override
    public List<Tarea> listarPendientes() {
        List<Tarea> pendientes = new ArrayList<>();
        for (Tarea t : baseDatos.values()) {
            if (!t.isCompletada()) {
                pendientes.add(t);
            }
        }
        return pendientes;
    }

    @Override
    public void eliminar(Long id) {
        baseDatos.remove(id);
    }
}
