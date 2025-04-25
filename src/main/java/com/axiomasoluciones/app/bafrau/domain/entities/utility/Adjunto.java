package com.axiomasoluciones.app.bafrau.domain.entities.utility;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import jakarta.persistence.*;

@Entity
@Table(name = "adjuntos")
public class Adjunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlAdjunto;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")  // Relacionar con Informe
    private Organizacion organizacion;

    public Adjunto() {
    }

    public Adjunto(Long id, String urlAdjunto, String descripcion, Organizacion organizacion) {
        this.id = id;
        this.urlAdjunto = urlAdjunto;
        this.descripcion = descripcion;
        this.organizacion = organizacion;
    }

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

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
