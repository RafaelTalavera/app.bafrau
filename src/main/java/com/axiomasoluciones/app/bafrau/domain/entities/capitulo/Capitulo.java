package com.axiomasoluciones.app.bafrau.domain.entities.capitulo;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import com.axiomasoluciones.app.bafrau.domain.entities.seccion.Seccion;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "capitulos")
public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificacion;

    private String titulo;
    private String descripcion;
    private Integer orden;

    @ManyToOne
    @JoinColumn(name = "informe_id")
    private Informe informe;

    @OneToMany(mappedBy = "capitulo", cascade = CascadeType.ALL)
    private List<Seccion> secciones;

    public Capitulo() {
    }

    public Capitulo(Long id, String identificacion, String titulo, String descripcion, Integer orden, Informe informe, List<Seccion> secciones) {
        this.id = id;
        this.identificacion = identificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.orden = orden;
        this.informe = informe;
        this.secciones = secciones;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}