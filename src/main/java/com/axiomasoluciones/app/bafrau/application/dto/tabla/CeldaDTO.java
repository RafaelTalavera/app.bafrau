package com.axiomasoluciones.app.bafrau.application.dto.tabla;

public class CeldaDTO {

    private Long id;
    private String valor;
    private Long columnaId;
    private Long filaId;

    public CeldaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getColumnaId() {
        return columnaId;
    }

    public void setColumnaId(Long columnaId) {
        this.columnaId = columnaId;
    }

    public Long getFilaId() {
        return filaId;
    }

    public void setFilaId(Long filaId) {
        this.filaId = filaId;
    }
}