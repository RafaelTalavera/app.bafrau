package com.axiomasoluciones.app.bafrau.application.dto.tabla;

public class TablaDTO {

    private Long id;
    private String nombre;
    private Long seccionId;
    private Long columnaId;

    public TablaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Long seccionId) {
        this.seccionId = seccionId;
    }

    public Long getColumnaId() {
        return columnaId;
    }

    public void setColumnaId(Long columnaId) {
        this.columnaId = columnaId;
    }
}
