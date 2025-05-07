package com.axiomasoluciones.app.bafrau.application.dto.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.capitulo.CapituloDTO;
import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;

import java.time.LocalDate;
import java.util.List;

public class OrganizacionDTO {

    private Long id;
    private LocalDate fechaAlta;
    private String tipoDeContrato;
    private String rrpp;
    private String nombreDelProponente;
    private String razonSocial;
    private String personariaJuridica;
    private String cuit;
    private String domicilioRealProyecto;
    private String domicilioLegalProyecto;
    private String situacionPredio;
    private String licenciaComercial;
    private String vencimientoLicenciaComercial;
    private String nomenclaturaCatatrasl;
    private String actividadPrincipal;
    private String actividadSecundaria;
    private List<CorreoDTO> correos;
    private List<TelefonoDTO> telefonos;
    private List<ServicioDisponibleDTO> serviciosDisponibles;
    private LocalDate fechaCreacion;
    private String dimensionPredio;
    private String superficieCubierta;
    private String superficieDescubierta;
    private String tecnologia;
    private Long userId;
    private List<ProcesoDTO> procesos;
    private List<ProcedimientoDTO> procedimientos;
    private List<AdjuntoDTO> adjuntoInformes;
    private List<CapituloDTO> capitulos;
    private List<NominaEmpleadosDTO> nominaEmpleados;
    private List<SectorDTO> sectores;

    public OrganizacionDTO() {
    }

    public OrganizacionDTO(Long id, LocalDate fechaAlta, String tipoDeContrato, String rrpp, String nombreDelProponente, String razonSocial, String personariaJuridica, String cuit, String domicilioRealProyecto, String domicilioLegalProyecto, String situacionPredio, String licenciaComercial, String vencimientoLicenciaComercial, String nomenclaturaCatatrasl, String actividadPrincipal, String actividadSecundaria, List<CorreoDTO> correos, List<TelefonoDTO> telefonos, List<ServicioDisponibleDTO> serviciosDisponibles, LocalDate fechaCreacion, String dimensionPredio, String superficieCubierta, String superficieDescubierta, String tecnologia, Long userId, List<ProcesoDTO> procesos, List<ProcedimientoDTO> procedimientos, List<AdjuntoDTO> adjuntoInformes, List<CapituloDTO> capitulos, List<NominaEmpleadosDTO> nominaEmpleados, List<SectorDTO> sectores) {
        this.id = id;
        this.fechaAlta = fechaAlta;
        this.tipoDeContrato = tipoDeContrato;
        this.rrpp = rrpp;
        this.nombreDelProponente = nombreDelProponente;
        this.razonSocial = razonSocial;
        this.personariaJuridica = personariaJuridica;
        this.cuit = cuit;
        this.domicilioRealProyecto = domicilioRealProyecto;
        this.domicilioLegalProyecto = domicilioLegalProyecto;
        this.situacionPredio = situacionPredio;
        this.licenciaComercial = licenciaComercial;
        this.vencimientoLicenciaComercial = vencimientoLicenciaComercial;
        this.nomenclaturaCatatrasl = nomenclaturaCatatrasl;
        this.actividadPrincipal = actividadPrincipal;
        this.actividadSecundaria = actividadSecundaria;
        this.correos = correos;
        this.telefonos = telefonos;
        this.serviciosDisponibles = serviciosDisponibles;
        this.fechaCreacion = fechaCreacion;
        this.dimensionPredio = dimensionPredio;
        this.superficieCubierta = superficieCubierta;
        this.superficieDescubierta = superficieDescubierta;
        this.tecnologia = tecnologia;
        this.userId = userId;
        this.procesos = procesos;
        this.procedimientos = procedimientos;
        this.adjuntoInformes = adjuntoInformes;
        this.capitulos = capitulos;
        this.nominaEmpleados = nominaEmpleados;
        this.sectores = sectores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getTipoDeContrato() {
        return tipoDeContrato;
    }

    public void setTipoDeContrato(String tipoDeContrato) {
        this.tipoDeContrato = tipoDeContrato;
    }

    public String getRrpp() {
        return rrpp;
    }

    public void setRrpp(String rrpp) {
        this.rrpp = rrpp;
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

    public String getPersonariaJuridica() {
        return personariaJuridica;
    }

    public void setPersonariaJuridica(String personariaJuridica) {
        this.personariaJuridica = personariaJuridica;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
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

    public String getSituacionPredio() {
        return situacionPredio;
    }

    public void setSituacionPredio(String situacionPredio) {
        this.situacionPredio = situacionPredio;
    }

    public String getLicenciaComercial() {
        return licenciaComercial;
    }

    public void setLicenciaComercial(String licenciaComercial) {
        this.licenciaComercial = licenciaComercial;
    }

    public String getVencimientoLicenciaComercial() {
        return vencimientoLicenciaComercial;
    }

    public void setVencimientoLicenciaComercial(String vencimientoLicenciaComercial) {
        this.vencimientoLicenciaComercial = vencimientoLicenciaComercial;
    }

    public String getNomenclaturaCatatrasl() {
        return nomenclaturaCatatrasl;
    }

    public void setNomenclaturaCatatrasl(String nomenclaturaCatatrasl) {
        this.nomenclaturaCatatrasl = nomenclaturaCatatrasl;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public String getActividadSecundaria() {
        return actividadSecundaria;
    }

    public void setActividadSecundaria(String actividadSecundaria) {
        this.actividadSecundaria = actividadSecundaria;
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public List<AdjuntoDTO> getAdjuntoInformes() {
        return adjuntoInformes;
    }

    public void setAdjuntoInformes(List<AdjuntoDTO> adjuntoInformes) {
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
