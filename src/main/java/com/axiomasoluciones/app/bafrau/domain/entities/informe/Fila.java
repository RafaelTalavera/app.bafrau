package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filas")
public class Fila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroFila; // 0, 1, 2, ...

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tabla_id", nullable = false)
    private Tabla tabla;

    @OneToMany(mappedBy = "fila", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("numeroColumna ASC")
    private List<Celda> celdas = new ArrayList<>();

    public Fila() {
    }

    public Fila(Long id, Integer numeroFila, Tabla tabla, List<Celda> celdas) {
        this.id = id;
        this.numeroFila = numeroFila;
        this.tabla = tabla;
        this.celdas = celdas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(Integer numeroFila) {
        this.numeroFila = numeroFila;
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public List<Celda> getCeldas() {
        return celdas;
    }

    public void setCeldas(List<Celda> celdas) {
        this.celdas = celdas;
    }
}
