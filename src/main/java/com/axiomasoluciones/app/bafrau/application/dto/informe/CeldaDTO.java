package com.axiomasoluciones.app.bafrau.application.dto.informe;

public class CeldaDTO {
    private Long id;
    private Integer numeroColumna;
    private String contenido;
    private Long filaId;

    public CeldaDTO() {
    }

    public CeldaDTO(Long id, Integer numeroColumna, String contenido, Long filaId) {
        this.id = id;
        this.numeroColumna = numeroColumna;
        this.contenido = contenido;
        this.filaId = filaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroColumna() {
        return numeroColumna;
    }

    public void setNumeroColumna(Integer numeroColumna) {
        this.numeroColumna = numeroColumna;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getFilaId() {
        return filaId;
    }

    public void setFilaId(Long filaId) {
        this.filaId = filaId;
    }
}
