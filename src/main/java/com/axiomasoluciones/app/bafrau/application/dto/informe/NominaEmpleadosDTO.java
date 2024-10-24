package com.axiomasoluciones.app.bafrau.application.dto.informe;

public class NominaEmpleadosDTO {

    private Long id;
    private String puesto;
    private String contrato;
    private int cantidad;
    private Long informeId;

    public NominaEmpleadosDTO() {
    }

    public NominaEmpleadosDTO(Long id, String puesto, String contrato, int cantidad, Long informeId) {
        this.id = id;
        this.puesto = puesto;
        this.contrato = contrato;
        this.cantidad = cantidad;
        this.informeId = informeId;
    }

    // Getters y setters
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

    public Long getInformeId() {
        return informeId;
    }

    public void setInformeId(Long informeId) {
        this.informeId = informeId;
    }
}