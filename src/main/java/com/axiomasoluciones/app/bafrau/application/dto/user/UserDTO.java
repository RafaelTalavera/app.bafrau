package com.axiomasoluciones.app.bafrau.application.dto.user;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;
import com.axiomasoluciones.app.bafrau.application.dto.matriz.MatrizDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.user.Role;

import java.util.List;

public class UserDTO {

    private Long id;
    private String username;
    private String nombre;
    private String lastname;
    private String dni;
    private String password;
    private String organizacion;
    private String titulo;
    private String matriculaProvincia;
    private String matriculaColegioNeuquen;
    private String matriculaMunicipal;
    private String address;
    private String phone;
    private Role role;
    private List<MatrizDTO> impactAssessments;
    private List<OrganizacionDTO> informes;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String nombre, String lastname, String dni, String password, String organizacion, String titulo, String matriculaProvincia, String matriculaColegioNeuquen, String matriculaMunicipal, String address, String phone, Role role, List<MatrizDTO> impactAssessments, List<OrganizacionDTO> informes) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.lastname = lastname;
        this.dni = dni;
        this.password = password;
        this.organizacion = organizacion;
        this.titulo = titulo;
        this.matriculaProvincia = matriculaProvincia;
        this.matriculaColegioNeuquen = matriculaColegioNeuquen;
        this.matriculaMunicipal = matriculaMunicipal;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.impactAssessments = impactAssessments;
        this.informes = informes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<MatrizDTO> getImpactAssessments() {
        return impactAssessments;
    }

    public void setImpactAssessments(List<MatrizDTO> impactAssessments) {
        this.impactAssessments = impactAssessments;
    }

    public List<OrganizacionDTO> getInformes() {
        return informes;
    }

    public void setInformes(List<OrganizacionDTO> informes) {
        this.informes = informes;
    }
}



