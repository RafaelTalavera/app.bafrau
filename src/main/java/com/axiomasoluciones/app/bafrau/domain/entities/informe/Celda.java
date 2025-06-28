package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import jakarta.persistence.*;

@Entity
@Table(name = "celdas")
public class Celda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroColumna; // 0,1,2,...
    @Column(columnDefinition = "TEXT")
    private String contenido; // texto, HTML o lo que se quiera permitir

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fila_id", nullable = false)
    private Fila fila;

    public Celda() {
    }

    public Celda(Long id, Integer numeroColumna, String contenido, Fila fila) {
        this.id = id;
        this.numeroColumna = numeroColumna;
        this.contenido = contenido;
        this.fila = fila;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroColumna() {
        return numeroColumna;
    }

    public void setNumeroColumna(Integer numeroColumna) {
        this.numeroColumna = numeroColumna;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }
}
