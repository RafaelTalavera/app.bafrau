package com.axiomasoluciones.app.bafrau.domain.entities.matriz;

import jakarta.persistence.*;

@Table(name = "items_informes")
@Entity
public class ItemMatriz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int magnitude;
    private int importance;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "accion_id")
    private Accion accion;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "factor_id")
    private Factor factor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matriz_id")
    private Matriz matriz;

    public ItemMatriz(Long id, int magnitude, int importance, Accion accion, Factor factor, Matriz matriz) {
        this.id = id;
        this.magnitude = magnitude;
        this.importance = importance;
        this.accion = accion;
        this.factor = factor;
        this.matriz = matriz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }
}
