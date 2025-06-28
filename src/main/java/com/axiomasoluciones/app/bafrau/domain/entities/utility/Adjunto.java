package com.axiomasoluciones.app.bafrau.domain.entities.utility;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Encabezado;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Seccion;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id", nullable = true)
    private Organizacion organizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seccion_id", nullable = true)
    private Seccion seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encabezado_id", nullable = true)
    private Encabezado encabezado;

    public Adjunto() {
    }

    public Adjunto(Long id, String urlAdjunto, String descripcion, Organizacion organizacion, Seccion seccion, Encabezado encabezado) {
        this.id = id;
        this.urlAdjunto = urlAdjunto;
        this.descripcion = descripcion;
        this.organizacion = organizacion;
        this.seccion = seccion;
        this.encabezado = encabezado;
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

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Encabezado getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Encabezado encabezado) {
        this.encabezado = encabezado;
    }
}
