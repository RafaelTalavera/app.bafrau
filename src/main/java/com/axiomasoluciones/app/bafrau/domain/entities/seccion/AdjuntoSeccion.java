package com.axiomasoluciones.app.bafrau.domain.entities.seccion;

import jakarta.persistence.*;

@Entity
@Table(name = "adjunto_secciones")
public class AdjuntoSeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlAdjunto;

    private String descricion;

    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    public AdjuntoSeccion() {
    }

    public AdjuntoSeccion(Long id, String urlAdjunto, String descricion, Seccion seccion) {
        this.id = id;
        this.urlAdjunto = urlAdjunto;
        this.descricion = descricion;
        this.seccion = seccion;
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

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
}
