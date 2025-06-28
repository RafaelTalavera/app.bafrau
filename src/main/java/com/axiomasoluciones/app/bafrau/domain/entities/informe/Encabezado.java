package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Auditable;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.StyleTemplate;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "encabezado")
@Entity
public class Encabezado extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id", nullable = false)
    private Informe informe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "style_template_id", nullable = false)
    private StyleTemplate styleTemplate;

    @OneToMany(mappedBy = "encabezado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Adjunto> adjuntos = new ArrayList<>();

    public Encabezado() {
    }

    public Encabezado(Long id, String contenido, Informe informe, StyleTemplate styleTemplate, List<Adjunto> adjuntos) {
        this.id = id;
        this.contenido = contenido;
        this.informe = informe;
        this.styleTemplate = styleTemplate;
        this.adjuntos = adjuntos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public StyleTemplate getStyleTemplate() {
        return styleTemplate;
    }

    public void setStyleTemplate(StyleTemplate styleTemplate) {
        this.styleTemplate = styleTemplate;
    }

    public List<Adjunto> getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(List<Adjunto> adjuntos) {
        this.adjuntos = adjuntos;
    }
}
