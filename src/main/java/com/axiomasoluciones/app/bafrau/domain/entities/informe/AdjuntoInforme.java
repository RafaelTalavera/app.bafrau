package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import jakarta.persistence.*;

@Entity
@Table(name = "adjunto_informes")
public class AdjuntoInforme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlAdjunto;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "informe_id")  // Relacionar con Informe
    private Informe informe;

    public AdjuntoInforme() {
    }

    public AdjuntoInforme(Long id, String urlAdjunto, String descripcion, Informe informe) {
        this.id = id;
        this.urlAdjunto = urlAdjunto;
        this.descripcion = descripcion;
        this.informe = informe;
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

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }
}
