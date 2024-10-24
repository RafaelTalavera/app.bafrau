package com.axiomasoluciones.app.bafrau.application.dto.tabla;



public class ColumnaDTO {

    private Long id;
    private String nombreColumna;
    private String tipoDato;
    private Long tablaId;
    private Long columnaId;

    public ColumnaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(String nombreColumna) {
        this.nombreColumna = nombreColumna;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public Long getTablaId() {
        return tablaId;
    }

    public void setTablaId(Long tablaId) {
        this.tablaId = tablaId;
    }

    public Long getColumnaId() {
        return columnaId;
    }

    public void setColumnaId(Long columnaId) {
        this.columnaId = columnaId;
    }
}