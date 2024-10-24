package com.axiomasoluciones.app.bafrau.domain.entities.tabla;

import com.axiomasoluciones.app.bafrau.domain.entities.seccion.Seccion;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tabla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    @OneToMany(mappedBy = "tabla", cascade = CascadeType.ALL)
    private List<Columna> columnas;

    public Tabla() {
    }

    public Tabla(Long id, String nombre, Seccion seccion, List<Columna> columnas) {
        this.id = id;
        this.nombre = nombre;
        this.seccion = seccion;
        this.columnas = columnas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<Columna> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<Columna> columnas) {
        this.columnas = columnas;
    }
}
