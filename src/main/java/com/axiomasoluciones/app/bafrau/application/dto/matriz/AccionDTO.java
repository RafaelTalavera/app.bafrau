package com.axiomasoluciones.app.bafrau.application.dto.matriz;


public class AccionDTO {

    private Long id;
    private String clasificacion;
    private String tipo;

    public AccionDTO() {
    }

    public AccionDTO(Long id, String clasificacion, String tipo) {
        this.id = id;
        this.clasificacion = clasificacion;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
