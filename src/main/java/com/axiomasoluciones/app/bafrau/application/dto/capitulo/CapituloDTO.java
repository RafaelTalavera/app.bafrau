package com.axiomasoluciones.app.bafrau.application.dto.capitulo;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InformeDTO;
import com.axiomasoluciones.app.bafrau.application.dto.seccion.SeccionDTO;

import java.util.List;

public class CapituloDTO {

    private Long id;
    private String identificacion;
    private String titulo;
    private String descripcion;
    private Integer orden;
    private InformeDTO informe;
    private List<SeccionDTO> secciones;

    public CapituloDTO() {
    }

    public CapituloDTO(Long id, String identificacion, String titulo, String descripcion, Integer orden, InformeDTO informe, List<SeccionDTO> secciones) {
        this.id = id;
        this.identificacion = identificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.orden = orden;
        this.informe = informe;
        this.secciones = secciones;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public InformeDTO getInforme() {
        return informe;
    }

    public void setInforme(InformeDTO informe) {
        this.informe = informe;
    }

    public List<SeccionDTO> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<SeccionDTO> secciones) {
        this.secciones = secciones;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
