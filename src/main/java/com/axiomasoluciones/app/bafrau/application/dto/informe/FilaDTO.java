package com.axiomasoluciones.app.bafrau.application.dto.informe;

import java.util.ArrayList;
import java.util.List;

public class FilaDTO {
    private Long id;
    private Integer numeroFila;
    private Long tablaId;
    private List<CeldaDTO> celdas = new ArrayList<>();

    public FilaDTO() {
    }

    public FilaDTO(Long id, Integer numeroFila, Long tablaId, List<CeldaDTO> celdas) {
        this.id = id;
        this.numeroFila = numeroFila;
        this.tablaId = tablaId;
        this.celdas = celdas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(Integer numeroFila) {
        this.numeroFila = numeroFila;
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