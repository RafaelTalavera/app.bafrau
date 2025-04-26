package com.axiomasoluciones.app.bafrau.application.dto.matriz;

public class ItemMatrizDTO {
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
    private Long accionId;
    private Long factorId;
    private Long matrizId;
    private String factorMedio;
    private String factorFactor;
    private String factorComponente;
    private int magnitude;
    private int importance;


    public ItemMatrizDTO() {}

    public ItemMatrizDTO(Long id, String etapa, String razonSocial, int naturaleza, int intensidad, int extension, int momento, int persistencia, int reversivilidad, int sinergia, int acumulacion, int efecto, int periodicidad, int recuperacion, int uIP, Long accionId, Long factorId, Long matrizId, String factorMedio, String factorFactor, String factorComponente, int magnitude, int importance) {
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
        this.accionId = accionId;
        this.factorId = factorId;
        this.matrizId = matrizId;
        this.factorMedio = factorMedio;
        this.factorFactor = factorFactor;
        this.factorComponente = factorComponente;
        this.magnitude = magnitude;
        this.importance = importance;
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

    public Long getAccionId() {
        return accionId;
    }

    public void setAccionId(Long accionId) {
        this.accionId = accionId;
    }

    public Long getFactorId() {
        return factorId;
    }

    public void setFactorId(Long factorId) {
        this.factorId = factorId;
    }

    public Long getMatrizId() {
        return matrizId;
    }

    public void setMatrizId(Long matrizId) {
        this.matrizId = matrizId;
    }

    public String getFactorMedio() {
        return factorMedio;
    }

    public void setFactorMedio(String factorMedio) {
        this.factorMedio = factorMedio;
    }

    public String getFactorFactor() {
        return factorFactor;
    }

    public void setFactorFactor(String factorFactor) {
        this.factorFactor = factorFactor;
    }

    public String getFactorComponente() {
        return factorComponente;
    }

    public void setFactorComponente(String factorComponente) {
        this.factorComponente = factorComponente;
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
}
