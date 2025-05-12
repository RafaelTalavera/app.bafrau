package com.axiomasoluciones.app.bafrau.application.dto.residuo;

import java.time.LocalDate;
import java.util.List;

public class InventarioDTO {

    private Long id;
    private LocalDate fecha;
    private Long organizacionId;
    private String contrato;
    private List<ItemInventarioDTO> items;

    public InventarioDTO() {
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

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public List<ItemInventarioDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemInventarioDTO> items) {
        this.items = items;
    }
}
