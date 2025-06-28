package com.axiomasoluciones.app.bafrau.application.dto.organizacion;

public class NominaEmpleadosDTO {

    private Long id;
    private String puesto;
    private String contrato;
    private int cantidad;
    private Long organizacionId;

    public NominaEmpleadosDTO() {
    }

    public NominaEmpleadosDTO(Long id, String puesto, String contrato, int cantidad, Long organizacionId) {
        this.id = id;
        this.puesto = puesto;
        this.contrato = contrato;
        this.cantidad = cantidad;
        this.organizacionId = organizacionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }
}