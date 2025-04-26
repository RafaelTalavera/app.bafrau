package com.axiomasoluciones.app.bafrau.domain.entities.matriz;

import jakarta.persistence.*;

@Table(name = "matriz_items")
@Entity
public class ItemMatriz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String etapa;
    private String razonSocial;
    private int naturaleza;
    private int intensidad;
    private int extension;
    private int momento;
    private int persistencia;
    private int reversivilidad;
    private int sinergia;
    private int acumulacion;
    private int efecto;
    private int periodicidad;
    private int recuperacion;
    private int uIP;
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

    public ItemMatriz() {
    }

    public ItemMatriz(Long id, String etapa, String razonSocial, int naturaleza, int intensidad, int extension, int momento, int persistencia, int reversivilidad, int sinergia, int acumulacion, int efecto, int periodicidad, int recuperacion, int uIP, int magnitude, int importance, Accion accion, Factor factor, Matriz matriz) {
        this.id = id;
        this.etapa = etapa;
        this.razonSocial = razonSocial;
        this.naturaleza = naturaleza;
        this.intensidad = intensidad;
        this.extension = extension;
        this.momento = momento;
        this.persistencia = persistencia;
        this.reversivilidad = reversivilidad;
        this.sinergia = sinergia;
        this.acumulacion = acumulacion;
        this.efecto = efecto;
        this.periodicidad = periodicidad;
        this.recuperacion = recuperacion;
        this.uIP = uIP;
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

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(int naturaleza) {
        this.naturaleza = naturaleza;
    }

    public int getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(int intensidad) {
        this.intensidad = intensidad;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public int getMomento() {
        return momento;
    }

    public void setMomento(int momento) {
        this.momento = momento;
    }

    public int getPersistencia() {
        return persistencia;
    }

    public void setPersistencia(int persistencia) {
        this.persistencia = persistencia;
    }

    public int getReversivilidad() {
        return reversivilidad;
    }

    public void setReversivilidad(int reversivilidad) {
        this.reversivilidad = reversivilidad;
    }

    public int getSinergia() {
        return sinergia;
    }

    public void setSinergia(int sinergia) {
        this.sinergia = sinergia;
    }

    public int getAcumulacion() {
        return acumulacion;
    }

    public void setAcumulacion(int acumulacion) {
        this.acumulacion = acumulacion;
    }

    public int getEfecto() {
        return efecto;
    }

    public void setEfecto(int efecto) {
        this.efecto = efecto;
    }

    public int getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }

    public int getRecuperacion() {
        return recuperacion;
    }

    public void setRecuperacion(int recuperacion) {
        this.recuperacion = recuperacion;
    }

    public int getuIP() {
        return uIP;
    }

    public void setuIP(int uIP) {
        this.uIP = uIP;
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
