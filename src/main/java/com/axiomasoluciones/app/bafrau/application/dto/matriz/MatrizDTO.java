package com.axiomasoluciones.app.bafrau.application.dto.matriz;

import java.time.LocalDate;
import java.util.List;

public class MatrizDTO {
    private Long id;
    private LocalDate fecha;
    private Long userId;
    private Long organizacionId;
    private List<ItemMatrizDTO> items;
    private String organizacionNombre;

    public MatrizDTO() {}

    public MatrizDTO(Long id, LocalDate fecha, Long userId, Long organizacionId, List<ItemMatrizDTO> items, String organizacionNombre) {
        this.id = id;
        this.fecha = fecha;
        this.userId = userId;
        this.organizacionId = organizacionId;
        this.items = items;
        this.organizacionNombre = organizacionNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }

    public List<ItemMatrizDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemMatrizDTO> items) {
        this.items = items;
    }

    public String getOrganizacionNombre() {
        return organizacionNombre;
    }

    public void setOrganizacionNombre(String organizacionNombre) {
        this.organizacionNombre = organizacionNombre;
    }
}
