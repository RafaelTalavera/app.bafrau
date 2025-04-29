package com.axiomasoluciones.app.bafrau.domain.services.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;

import java.util.List;
import java.util.Optional;

public interface OrganizacionService {

    List<OrganizacionDTO> findAll();

    Optional<OrganizacionDTO> findById(Long id);

    OrganizacionDTO create(OrganizacionDTO organizacionDTO, String token);

    OrganizacionDTO update(Long id, OrganizacionDTO organizacionDTO);

    void deleteById(Long id);

    List<OrganizacionDTO> findByOrganizacion(String organizacion);

    String extractOrganizacionFromToken(String token);

    List<OrganizacionDTO> obtenerRazonesSociales();

    List<OrganizacionDTO> findByTipoDeContrato(String tipoDeContrato);

}