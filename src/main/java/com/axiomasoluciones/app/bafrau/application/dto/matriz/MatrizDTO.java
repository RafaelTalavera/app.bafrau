package com.axiomasoluciones.app.bafrau.application.dto.matriz;



import java.time.LocalDate;
import java.util.List;

public class MatrizDTO {
    private Long id;
    private LocalDate fecha;
    private String organizacion;
    private String direccion;
    private String rubro;
    private Long userId;
    private Long seccionId;
    private List<ItemMatrizDTO> items;

    public MatrizDTO() {
    }

    public MatrizDTO(Long id, LocalDate fecha, String organizacion, String direccion, String rubro, Long userId, Long seccionId, List<ItemMatrizDTO> items) {
        this.id = id;
        this.fecha = fecha;
        this.organizacion = organizacion;
        this.direccion = direccion;
        this.rubro = rubro;
        this.userId = userId;
        this.seccionId = seccionId;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ItemMatrizDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemMatrizDTO> items) {
        this.items = items;
    }

    public Long getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Long seccionId) {
        this.seccionId = seccionId;
    }
}
