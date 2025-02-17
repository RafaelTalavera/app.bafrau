package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.capitulo.Capitulo;
import com.axiomasoluciones.app.bafrau.domain.entities.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "informes")
public class Informe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaAlta;
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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id")
    private List<Correo> correos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id")
    private List<Telefono> telefonos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id")
    private List<ServicioDisponible> serviciosDisponibles;

    private LocalDate fechaCreacion;

    private String dimensionPredio;
    private String superficieCubierta;
    private String superficieDescubierta;
    private String tecnologia;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Relación con el usuario que crea el informe

    // Relación OneToMany con procesos, capitulos, procedimientos, sectores y adjuntos
    @OneToMany(mappedBy = "informe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Proceso> procesos;

    @OneToMany(mappedBy = "informe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Procedimiento> procedimientos;

    @OneToMany(mappedBy = "informe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdjuntoInforme> adjuntoInformes;

    @OneToMany(mappedBy = "informe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Capitulo> capitulos;

    @OneToMany(mappedBy = "informe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NominaEmpleados> nominaEmpleados;

    @OneToMany(mappedBy = "informe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sector> sectores;


    public Informe() {
    }

    public Informe(Long id, LocalDate fechaAlta, String nombreDelProponente, String razonSocial, String personariaJuridica, String cuit, String domicilioRealProyecto, String domicilioLegalProyecto, String situacionPredio, String licenciaComercial, String vencimientoLicenciaComercial, String nomenclaturaCatatrasl, String actividadPrincipal, String actividadSecundaria, List<Correo> correos, List<Telefono> telefonos, List<ServicioDisponible> serviciosDisponibles, LocalDate fechaCreacion, String dimensionPredio, String superficieCubierta, String superficieDescubierta, String tecnologia, User user, List<Proceso> procesos, List<Procedimiento> procedimientos, List<AdjuntoInforme> adjuntoInformes, List<Capitulo> capitulos, List<NominaEmpleados> nominaEmpleados, List<Sector> sectores) {
        this.id = id;
        this.fechaAlta = fechaAlta;
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
        this.user = user;
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

    public List<Correo> getCorreos() {
        return correos;
    }

    public void setCorreos(List<Correo> correos) {
        this.correos = correos;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<ServicioDisponible> getServiciosDisponibles() {
        return serviciosDisponibles;
    }

    public void setServiciosDisponibles(List<ServicioDisponible> serviciosDisponibles) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public List<Procedimiento> getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(List<Procedimiento> procedimientos) {
        this.procedimientos = procedimientos;
    }

    public List<AdjuntoInforme> getAdjuntoInformes() {
        return adjuntoInformes;
    }

    public void setAdjuntoInformes(List<AdjuntoInforme> adjuntoInformes) {
        this.adjuntoInformes = adjuntoInformes;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public List<NominaEmpleados> getNominaEmpleados() {
        return nominaEmpleados;
    }

    public void setNominaEmpleados(List<NominaEmpleados> nominaEmpleados) {
        this.nominaEmpleados = nominaEmpleados;
    }

    public List<Sector> getSectores() {
        return sectores;
    }

    public void setSectores(List<Sector> sectores) {
        this.sectores = sectores;
    }
}


