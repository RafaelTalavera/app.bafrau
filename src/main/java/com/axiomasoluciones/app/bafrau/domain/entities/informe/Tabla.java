package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tablas")
public class Tabla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seccion_id", nullable = false)
    private Seccion seccion;


    @OneToMany(mappedBy = "tabla", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("numeroFila ASC")
    private List<Fila> filas = new ArrayList<>();

    public Tabla() {
    }

    public Tabla(Long id, String nombre, Seccion seccion, List<Fila> filas) {
        this.id = id;
        this.nombre = nombre;
        this.seccion = seccion;
        this.filas = filas;
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

    public List<Fila> getFilas() {
        return filas;
    }

    public void setFilas(List<Fila> filas) {
        this.filas = filas;
    }
}