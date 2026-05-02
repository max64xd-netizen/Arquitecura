package org.example.tareashexagonal.domain.ports.input;

import org.example.tareashexagonal.domain.model.Tarea;
import java.util.List;

public interface TareaUseCase {

    Tarea crearTarea(String titulo, String descripcion);

    List<Tarea> listarTareas();

    Tarea completarTarea(Long id);

    // ✅ NUEVO: obtener pendientes
    List<Tarea> obtenerPendientes();

    // ✅ NUEVO: eliminar tarea
    void eliminarTarea(Long id);
}