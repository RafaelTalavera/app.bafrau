package com.axiomasoluciones.app.bafrau.application.dto.informe;

public class TelefonoDTO {
    private Long id;
    private String telefono;
    private Long informeId;
    private String nombre;

    public Long getInformeId() {
        return informeId;
    }

    public void setInformeId(Long informeId) {
        this.informeId = informeId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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
}
