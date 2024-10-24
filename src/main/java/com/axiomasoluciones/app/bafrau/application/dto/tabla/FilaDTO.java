package com.axiomasoluciones.app.bafrau.application.dto.tabla;

import java.util.List;

public class FilaDTO {

    private Long id;
    private Long tablaId;
    private List<CeldaDTO> celdas;

    public FilaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTablaId() {
        return tablaId;
    }

    public void setTablaId(Long tablaId) {
        this.tablaId = tablaId;
    }

    public List<CeldaDTO> getCeldas() {
        return celdas;
    }

    public void setCeldas(List<CeldaDTO> celdas) {
        this.celdas = celdas;
    }
}