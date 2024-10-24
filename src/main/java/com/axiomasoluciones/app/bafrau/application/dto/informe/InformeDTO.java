package com.axiomasoluciones.app.bafrau.application.dto.informe;

import com.axiomasoluciones.app.bafrau.application.dto.capitulo.CapituloDTO;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class InformeDTO {

    private Long id;
    private String nombreDelProponente;
    private String razonSocial;
    private String apoderadoLegal;
    private String apoderadoCargo;
    private String domicilioRealProyecto;
    private String domicilioLegalProyecto;

    private List<CorreoDTO> correos;
    private List<TelefonoDTO> telefonos;
    private List<ServicioDisponibleDTO> serviciosDisponibles;

    private String situacionPredio;
    private String nomenclaturaCatatrasl;
    private String licenciaComercial;
    private String cuit;
    private String personeriaJuridica;
    private LocalDate fechaCreacion;
    private String actividadPrincipal;
    private String dimensionPredio;
    private String superficieCubierta;
    private String superficieDescubierta;

    private String tecnologia;

    private Long userId;

    private List<ProcesoDTO> procesos;
    private List<ProcedimientoDTO> procedimientos;
    private List<AdjuntoInformeDTO> adjuntoInformes;
    private List<CapituloDTO> capitulos;
    private List<NominaEmpleadosDTO> nominaEmpleados;
    private List<SectorDTO> sectores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDelProponente() {
        return nombreDelProponente;
    }

    public void setNombreDelProponente(String nombreDelProponente) {
        this.nombreDelProponente = nombreDelProponente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getApoderadoLegal() {
        return apoderadoLegal;
    }

    public void setApoderadoLegal(String apoderadoLegal) {
        this.apoderadoLegal = apoderadoLegal;
    }

    public String getApoderadoCargo() {
        return apoderadoCargo;
    }

    public void setApoderadoCargo(String apoderadoCargo) {
        this.apoderadoCargo = apoderadoCargo;
    }

    public String getDomicilioRealProyecto() {
        return domicilioRealProyecto;
    }

    public void setDomicilioRealProyecto(String domicilioRealProyecto) {
        this.domicilioRealProyecto = domicilioRealProyecto;
    }

    public String getDomicilioLegalProyecto() {
        return domicilioLegalProyecto;
    }

    public void setDomicilioLegalProyecto(String domicilioLegalProyecto) {
        this.domicilioLegalProyecto = domicilioLegalProyecto;
    }

    public List<CorreoDTO> getCorreos() {
        return correos;
    }

    public void setCorreos(List<CorreoDTO> correos) {
        this.correos = correos;
    }

    public List<TelefonoDTO> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoDTO> telefonos) {
        this.telefonos = telefonos;
    }

    public List<ServicioDisponibleDTO> getServiciosDisponibles() {
        return serviciosDisponibles;
    }

    public void setServiciosDisponibles(List<ServicioDisponibleDTO> serviciosDisponibles) {
        this.serviciosDisponibles = serviciosDisponibles;
    }

    public String getSituacionPredio() {
        return situacionPredio;
    }

    public void setSituacionPredio(String situacionPredio) {
        this.situacionPredio = situacionPredio;
    }

    public String getNomenclaturaCatatrasl() {
        return nomenclaturaCatatrasl;
    }

    public void setNomenclaturaCatatrasl(String nomenclaturaCatatrasl) {
        this.nomenclaturaCatatrasl = nomenclaturaCatatrasl;
    }

    public String getLicenciaComercial() {
        return licenciaComercial;
    }

    public void setLicenciaComercial(String licenciaComercial) {
        this.licenciaComercial = licenciaComercial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getPersoneriaJuridica() {
        return personeriaJuridica;
    }

    public void setPersoneriaJuridica(String personeriaJuridica) {
        this.personeriaJuridica = personeriaJuridica;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public String getDimensionPredio() {
        return dimensionPredio;
    }

    public void setDimensionPredio(String dimensionPredio) {
        this.dimensionPredio = dimensionPredio;
    }

    public String getSuperficieCubierta() {
        return superficieCubierta;
    }

    public void setSuperficieCubierta(String superficieCubierta) {
        this.superficieCubierta = superficieCubierta;
    }

    public String getSuperficieDescubierta() {
        return superficieDescubierta;
    }

    public void setSuperficieDescubierta(String superficieDescubierta) {
        this.superficieDescubierta = superficieDescubierta;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProcesoDTO> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<ProcesoDTO> procesos) {
        this.procesos = procesos;
    }

    public List<ProcedimientoDTO> getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(List<ProcedimientoDTO> procedimientos) {
        this.procedimientos = procedimientos;
    }

    public List<AdjuntoInformeDTO> getAdjuntoInformes() {
        return adjuntoInformes;
    }

    public void setAdjuntoInformes(List<AdjuntoInformeDTO> adjuntoInformes) {
        this.adjuntoInformes = adjuntoInformes;
    }

    public List<CapituloDTO> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<CapituloDTO> capitulos) {
        this.capitulos = capitulos;
    }

    public List<NominaEmpleadosDTO> getNominaEmpleados() {
        return nominaEmpleados;
    }

    public void setNominaEmpleados(List<NominaEmpleadosDTO> nominaEmpleados) {
        this.nominaEmpleados = nominaEmpleados;
    }

    public List<SectorDTO> getSectores() {
        return sectores;
    }

    public void setSectores(List<SectorDTO> sectores) {
        this.sectores = sectores;
    }
}
