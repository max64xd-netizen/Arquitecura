package org.example.tareashexagonal.infrastructure.entrypoints;

import org.example.tareashexagonal.domain.model.Tarea;
import org.example.tareashexagonal.domain.ports.input.TareaUseCase;
import org.example.tareashexagonal.infrastructure.entrypoints.dto.CrearTareaRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    private final TareaUseCase useCase;

    public TareaController(TareaUseCase useCase) {
        this.useCase = useCase;
    }

    // CREAR
    @PostMapping
    public Tarea crear(@RequestBody CrearTareaRequest request) {
        return useCase.crearTarea(
                request.getTitulo(),
                request.getDescripcion()
        );
    }

    // LISTAR TODAS
    @GetMapping
    public List<Tarea> listar() {
        return useCase.listarTareas();
    }

    // COMPLETAR
    @PutMapping("/{id}/completar")
    public Tarea completar(@PathVariable Long id) {
        return useCase.completarTarea(id);
    }

    // PENDIENTES
    @GetMapping("/pendientes")
    public List<Tarea> pendientes() {
        return useCase.obtenerPendientes();
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        useCase.eliminarTarea(id);
        return "Tarea eliminada correctamente";
    }
}
