package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import jakarta.persistence.*;

@Entity
@Table(name = "nomina_empleados")
public class NominaEmpleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String puesto;

    private String contrato;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "informe_id")  // Llave foránea a la entidad Informe
    private Informe informe;

    public NominaEmpleados() {
    }

    public NominaEmpleados(Long id, String puesto, String contrato, int cantidad, Informe informe) {
        this.id = id;
        this.puesto = puesto;
        this.contrato = contrato;
        this.cantidad = cantidad;
        this.informe = informe;
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

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }
}