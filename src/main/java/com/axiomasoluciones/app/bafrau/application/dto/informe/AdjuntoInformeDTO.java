package com.axiomasoluciones.app.bafrau.application.dto.informe;

public class AdjuntoInformeDTO {

    private Long id;
    private String urlAdjunto;
    private String descripcion; // corregido el typo en 'descricion'
    private Long informeId; // Solo se pasa el ID de la entidad Informe

    // Constructor por defecto
    public AdjuntoInformeDTO() {
    }

    // Constructor con parámetros
    public AdjuntoInformeDTO(Long id, String urlAdjunto, String descripcion, Long informeId) {
        this.id = id;
        this.urlAdjunto = urlAdjunto;
        this.descripcion = descripcion;
        this.informeId = informeId;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlAdjunto() {
        return urlAdjunto;
    }

    public void setUrlAdjunto(String urlAdjunto) {
        this.urlAdjunto = urlAdjunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getInformeId() {
        return informeId;
    }

    public void setInformeId(Long informeId) {
        this.informeId = informeId;
    }
}
