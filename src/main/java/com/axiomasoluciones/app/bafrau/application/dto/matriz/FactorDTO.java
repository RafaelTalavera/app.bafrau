package com.axiomasoluciones.app.bafrau.application.dto.matriz;


public class FactorDTO {

    private Long id;
    private String medio;
    private String factor;
    private String componente;

    public FactorDTO() {
    }

    public FactorDTO(Long id, String medio, String factor, String componente) {
        this.id = id;
        this.medio = medio;
        this.factor = factor;
        this.componente = componente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }
}
