package com.axiomasoluciones.app.bafrau.domain.services.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ServicioDisponibleDTO;

import java.util.List;
import java.util.Optional;

public interface IServicioDisponibleService {
    List<ServicioDisponibleDTO> findAll();

    Optional<ServicioDisponibleDTO> findById(Long id);

    ServicioDisponibleDTO create(ServicioDisponibleDTO servicioDisponibleDTO);

    ServicioDisponibleDTO update(Long id, ServicioDisponibleDTO servicioDisponibleDTO);

    void delete(Long id);

    List<ServicioDisponibleDTO> getServicioDisponibleByOrganizacionId(Long organizacionId);
}