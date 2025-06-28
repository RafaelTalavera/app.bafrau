package com.axiomasoluciones.app.bafrau.application.dto.organizacion;

public class CorreoDTO {
    private Long id;
    private String correo;
    private Long organizacionId;
    private String nombre;

    public CorreoDTO() {
    }

    public CorreoDTO(Long id, String correo, Long organizacionId, String nombre) {
        this.id = id;
        this.correo = correo;
        this.organizacionId = organizacionId;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
