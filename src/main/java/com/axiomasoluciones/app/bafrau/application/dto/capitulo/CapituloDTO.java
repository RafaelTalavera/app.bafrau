package com.axiomasoluciones.app.bafrau.application.dto.capitulo;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;
import com.axiomasoluciones.app.bafrau.application.dto.seccion.SeccionDTO;

import java.util.List;

public class CapituloDTO {

    private Long id;
    private String identificacion;
    private String titulo;
    private String descripcion;
    private Integer orden;
    private OrganizacionDTO organizacion;
    private List<SeccionDTO> secciones;

    public CapituloDTO() {
    }

    public CapituloDTO(Long id, String identificacion, String titulo, String descripcion, Integer orden, OrganizacionDTO organizacion, List<SeccionDTO> secciones) {
        this.id = id;
        this.identificacion = identificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.orden = orden;
        this.organizacion = organizacion;
        this.secciones = secciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public OrganizacionDTO getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionDTO organizacion) {
        this.organizacion = organizacion;
    }

    public List<SeccionDTO> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<SeccionDTO> secciones) {
        this.secciones = secciones;
    }
}
