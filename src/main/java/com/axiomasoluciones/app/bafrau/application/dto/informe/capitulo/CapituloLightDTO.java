
package com.axiomasoluciones.app.bafrau.application.dto.informe.capitulo;

public class CapituloLightDTO {
    private Long id;
    private String titulo;
    private Integer orden;
    private Long informeId;

    public CapituloLightDTO(Long id, String titulo, Integer orden, Long informeId) {
        this.id = id;
        this.titulo = titulo;
        this.orden = orden;
        this.informeId = informeId;
    }

    public CapituloLightDTO() {}

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public Integer getOrden() { return orden; }
    public Long getInformeId() { return informeId; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setOrden(Integer orden) { this.orden = orden; }
    public void setInformeId(Long informeId) { this.informeId = informeId; }
}
