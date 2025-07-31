package com.axiomasoluciones.app.bafrau.application.dto.informe;

import java.util.List;
import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;

public class CaratulaDTO {

    private Long id;
    private String titulo;
    private String elaborador;
    /** Formato "MM-yyyy" */
    private String fecha;

    /** Relación con Informe */
    private Long informeId;

    /** Para crear junto con los datos completos de cada adjunto */
    private List<AdjuntoDTO> adjuntos;

    /** Para actualizar la relación: lista de IDs de adjuntos existentes */
    private List<Long> adjuntosIds;

    // Getters y setters

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

    public String getElaborador() {
        return elaborador;
    }
    public void setElaborador(String elaborador) {
        this.elaborador = elaborador;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getInformeId() {
        return informeId;
    }
    public void setInformeId(Long informeId) {
        this.informeId = informeId;
    }

    public List<AdjuntoDTO> getAdjuntos() {
        return adjuntos;
    }
    public void setAdjuntos(List<AdjuntoDTO> adjuntos) {
        this.adjuntos = adjuntos;
    }

    public List<Long> getAdjuntosIds() {
        return adjuntosIds;
    }
    public void setAdjuntosIds(List<Long> adjuntosIds) {
        this.adjuntosIds = adjuntosIds;
    }
}
