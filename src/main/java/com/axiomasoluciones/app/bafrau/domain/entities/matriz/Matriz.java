package com.axiomasoluciones.app.bafrau.domain.entities.matriz;

import com.axiomasoluciones.app.bafrau.domain.entities.seccion.Seccion;
import com.axiomasoluciones.app.bafrau.domain.entities.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Table(name = "matrices")
@Entity
public class Matriz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private String organizacion;

    private String direccion;

    private String rubro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "matriz")
    private List<ItemMatriz> items;

    public Matriz() {
    }

    public Matriz(Long id, LocalDate fecha, String organizacion, String direccion, String rubro, User user, Seccion seccion, List<ItemMatriz> items) {
        this.id = id;
        this.fecha = fecha;
        this.organizacion = organizacion;
        this.direccion = direccion;
        this.rubro = rubro;
        this.user = user;
        this.seccion = seccion;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<ItemMatriz> getItems() {
        return items;
    }

    public void setItems(List<ItemMatriz> items) {
        this.items = items;
    }
}
