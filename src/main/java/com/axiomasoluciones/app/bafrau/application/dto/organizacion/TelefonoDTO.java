package com.axiomasoluciones.app.bafrau.application.dto.organizacion;

public class TelefonoDTO {
    private Long id;
    private String telefono;
    private Long organizacionId;
    private String nombre;

    public TelefonoDTO() {
    }

    public TelefonoDTO(Long id, String telefono, Long organizacionId, String nombre) {
        this.id = id;
        this.telefono = telefono;
        this.organizacionId = organizacionId;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
