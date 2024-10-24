package com.axiomasoluciones.app.bafrau.domain.entities.tabla;

import jakarta.persistence.*;

@Entity
public class Celda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valor;

    @ManyToOne
    @JoinColumn(name = "columna_id")
    private Columna columna;

    @ManyToOne
    @JoinColumn(name = "fila_id")
    private Fila fila;

    public Celda() {
    }

    public Celda(Long id, String valor, Columna columna, Fila fila) {
        this.id = id;
        this.valor = valor;
        this.columna = columna;
        this.fila = fila;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Columna getColumna() {
        return columna;
    }

    public void setColumna(Columna columna) {
        this.columna = columna;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }
}
