package org.example.tareashexagonal.domain.model;

public class Tarea {

    private Long id;
    private String titulo;
    private String descripcion;
    private boolean completada;

    // 🔥 Constructor vacío (CLAVE)
    public Tarea() {
    }

    public Tarea(Long id, String titulo, String descripcion, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public boolean isCompletada() { return completada; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCompletada(boolean completada) { this.completada = completada; }

    public void completar() {
        this.completada = true;
    }
}