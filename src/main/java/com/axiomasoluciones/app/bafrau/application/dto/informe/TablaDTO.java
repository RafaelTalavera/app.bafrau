package com.axiomasoluciones.app.bafrau.application.dto.informe;

import java.util.ArrayList;
import java.util.List;

public class TablaDTO {
    private Long id;
    private String nombre;
    private Long seccionId;               // sólo ID, no toda la entidad
    private List<FilaDTO> filas = new ArrayList<>();

    public TablaDTO() {
    }

    public TablaDTO(Long id, String nombre, Long seccionId, List<FilaDTO> filas) {
        this.id = id;
        this.nombre = nombre;
        this.seccionId = seccionId;
        this.filas = filas;
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

    public List<FilaDTO> getFilas() {
        return filas;
    }

    public void setFilas(List<FilaDTO> filas) {
        this.filas = filas;
    }
}