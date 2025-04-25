package com.axiomasoluciones.app.bafrau.domain.entities.seccion;

import com.axiomasoluciones.app.bafrau.domain.entities.capitulo.Capitulo;
import com.axiomasoluciones.app.bafrau.domain.entities.tabla.Tabla;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Matriz;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "seccioones")
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "capitulo_id")
    private Capitulo capitulo;

    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private List<Tabla> tablas;


    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private List<AdjuntoSeccion> adjuntoSeccionList; // Relación con la entidad Imagen

    public Seccion() {
    }

    public Seccion(Long id, String titulo, String texto, Capitulo capitulo, List<Tabla> tablas, List<AdjuntoSeccion> adjuntoSeccionList) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.capitulo = capitulo;
        this.tablas = tablas;
        this.adjuntoSeccionList = adjuntoSeccionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }

    public List<Tabla> getTablas() {
        return tablas;
    }

    public void setTablas(List<Tabla> tablas) {
        this.tablas = tablas;
    }

    public List<AdjuntoSeccion> getAdjuntoSeccionList() {
        return adjuntoSeccionList;
    }

    public void setAdjuntoSeccionList(List<AdjuntoSeccion> adjuntoSeccionList) {
        this.adjuntoSeccionList = adjuntoSeccionList;
    }
}

