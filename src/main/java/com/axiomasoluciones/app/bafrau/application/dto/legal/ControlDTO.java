package com.axiomasoluciones.app.bafrau.application.dto.legal;

import java.time.LocalDate;
import java.util.List;

public class ControlDTO {

    private Long id;
    private Long organizacionId;
    private LocalDate fecha;
    private List<ItemControlDTO> items;
    private String organizacionRazonSocial;

    public ControlDTO() {
    }

    public ControlDTO(Long id, Long organizacionId, LocalDate fecha, List<ItemControlDTO> items, String organizacionRazonSocial) {
        this.id = id;
        this.organizacionId = organizacionId;
        this.fecha = fecha;
        this.items = items;
        this.organizacionRazonSocial = organizacionRazonSocial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<ItemControlDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemControlDTO> items) {
        this.items = items;
    }

    public String getOrganizacionRazonSocial() {
        return organizacionRazonSocial;
    }

    public void setOrganizacionRazonSocial(String organizacionRazonSocial) {
        this.organizacionRazonSocial = organizacionRazonSocial;
    }
}
