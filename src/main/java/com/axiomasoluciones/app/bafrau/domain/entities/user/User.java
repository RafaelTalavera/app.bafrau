package com.axiomasoluciones.app.bafrau.domain.entities.user;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Matriz;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Table(name = "usuarios")
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //mail
    private String username;
    private String nombre;
    private String lastname;
    private String password;
    private String dni;
    private String organizacion;
    private String titulo;
    private String matriculaProvincia;
    private String matriculaColegioNeuquen;
    private String matriculaMunicipal;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matriz> impactAssessments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Organizacion> informe;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = role.getPermissions().stream()
                .map(permissionEnum -> new SimpleGrantedAuthority(permissionEnum.name()))
                .collect(Collectors.toList());

        return authorities;
    }

    public User() {
    }

    public User(Long id, String username, String nombre, String lastname, String password, String dni, String organizacion, String titulo, String matriculaProvincia, String matriculaColegioNeuquen, String matriculaMunicipal, String address, String phone, List<Matriz> impactAssessments, List<Organizacion> informe, Role role) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.lastname = lastname;
        this.password = password;
        this.dni = dni;
        this.organizacion = organizacion;
        this.titulo = titulo;
        this.matriculaProvincia = matriculaProvincia;
        this.matriculaColegioNeuquen = matriculaColegioNeuquen;
        this.matriculaMunicipal = matriculaMunicipal;
        this.address = address;
        this.phone = phone;
        this.impactAssessments = impactAssessments;
        this.informe = informe;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMatriculaProvincia() {
        return matriculaProvincia;
    }

    public void setMatriculaProvincia(String matriculaProvincia) {
        this.matriculaProvincia = matriculaProvincia;
    }

    public String getMatriculaColegioNeuquen() {
        return matriculaColegioNeuquen;
    }

    public void setMatriculaColegioNeuquen(String matriculaColegioNeuquen) {
        this.matriculaColegioNeuquen = matriculaColegioNeuquen;
    }

    public String getMatriculaMunicipal() {
        return matriculaMunicipal;
    }

    public void setMatriculaMunicipal(String matriculaMunicipal) {
        this.matriculaMunicipal = matriculaMunicipal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Matriz> getImpactAssessments() {
        return impactAssessments;
    }

    public void setImpactAssessments(List<Matriz> impactAssessments) {
        this.impactAssessments = impactAssessments;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Organizacion> getInforme() {
        return informe;
    }

    public void setInforme(List<Organizacion> informe) {
        this.informe = informe;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}



