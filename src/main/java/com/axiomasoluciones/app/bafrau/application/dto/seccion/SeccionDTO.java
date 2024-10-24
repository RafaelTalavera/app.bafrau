package com.axiomasoluciones.app.bafrau.application.dto.seccion;

import com.axiomasoluciones.app.bafrau.application.dto.tabla.TablaDTO;
import com.axiomasoluciones.app.bafrau.application.dto.matriz.MatrizDTO;


import java.util.List;

public class SeccionDTO {
    private Long id;
    private String titulo;
    private String texto;
    private Long capituloId; // Solo se usa el ID de Capitulo
    private Long seccionId; // Lista de tablas asociadas a la sección
    private List<TablaDTO> tablas; // Lista de tablas asociadas a la sección
    private List<MatrizDTO> matrices; // Lista de matrices asociadas a la sección
    private List<AdjuntoSeccionDTO> adjuntoSeccionList; // Lista de adjuntos asociados a la sección

    public SeccionDTO() {
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getCapituloId() {
        return capituloId;
    }

    public void setCapituloId(Long capituloId) {
        this.capituloId = capituloId;
    }

    public Long getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Long seccionId) {
        this.seccionId = seccionId;
    }

    public List<TablaDTO> getTablas() {
        return tablas;
    }

    public void setTablas(List<TablaDTO> tablas) {
        this.tablas = tablas;
    }

    public List<MatrizDTO> getMatrices() {
        return matrices;
    }

    public void setMatrices(List<MatrizDTO> matrices) {
        this.matrices = matrices;
    }

    public List<AdjuntoSeccionDTO> getAdjuntoSeccionList() {
        return adjuntoSeccionList;
    }

    public void setAdjuntoSeccionList(List<AdjuntoSeccionDTO> adjuntoSeccionList) {
        this.adjuntoSeccionList = adjuntoSeccionList;
    }
}
