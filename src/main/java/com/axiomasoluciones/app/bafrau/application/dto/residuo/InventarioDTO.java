package com.axiomasoluciones.app.bafrau.application.dto.residuo;

import java.time.LocalDate;
import java.util.List;

public class InventarioDTO {

    private Long id;
    private LocalDate fecha;
    private Long organizacionId;
    private List<ItemInventarioDTO> items;

    public InventarioDTO() {
    }

    public InventarioDTO(Long id, LocalDate fecha, Long organizacionId, List<ItemInventarioDTO> items) {
        this.id = id;
        this.fecha = fecha;
        this.organizacionId = organizacionId;
        this.items = items;
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

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }

    public List<ItemInventarioDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemInventarioDTO> items) {
        this.items = items;
    }
}
