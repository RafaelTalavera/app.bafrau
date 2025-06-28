package com.axiomasoluciones.app.bafrau.application.dto.informe;

public class OrdenSeccionDTO {
    private Long id;
    private Integer orden;

    public OrdenSeccionDTO() {}
    public OrdenSeccionDTO(Long id, Integer orden) {
        this.id = id;
        this.orden = orden;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getOrden() { return orden; }
    public void setOrden(Integer orden) { this.orden = orden; }
}
