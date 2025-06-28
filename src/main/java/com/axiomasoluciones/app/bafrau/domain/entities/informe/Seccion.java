package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Auditable;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.StyleTemplate;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "secciones")
@Entity
public class Seccion extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int orden;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capitulo_id", nullable = false)
    private Capitulo capitulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "style_template_id", nullable = false)
    private StyleTemplate styleTemplate;

    @OneToMany(mappedBy = "seccion",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Adjunto> adjuntos = new ArrayList<>();

    @OneToMany(mappedBy = "seccion",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Tabla> tablas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id", nullable = false)
    private Organizacion organizacion;

    public Seccion() {
    }

    public Seccion(Long id, int orden, String contenido, Capitulo capitulo, StyleTemplate styleTemplate, List<Adjunto> adjuntos, List<Tabla> tablas, Organizacion organizacion) {
        this.id = id;
        this.orden = orden;
        this.contenido = contenido;
        this.capitulo = capitulo;
        this.styleTemplate = styleTemplate;
        this.adjuntos = adjuntos;
        this.tablas = tablas;
        this.organizacion = organizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
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

    public List<Tabla> getTablas() {
        return tablas;
    }

    public void setTablas(List<Tabla> tablas) {
        this.tablas = tablas;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
