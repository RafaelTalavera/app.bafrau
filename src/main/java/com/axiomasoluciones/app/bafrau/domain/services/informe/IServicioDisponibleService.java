package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.ServicioDisponibleDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.TelefonoDTO;

import java.util.List;
import java.util.Optional;

public interface IServicioDisponibleService {
    List<ServicioDisponibleDTO> findAll();

    Optional<ServicioDisponibleDTO> findById(Long id);

    ServicioDisponibleDTO create(ServicioDisponibleDTO servicioDisponibleDTO);

    ServicioDisponibleDTO update(Long id, ServicioDisponibleDTO servicioDisponibleDTO);

    void delete(Long id);

    List<ServicioDisponibleDTO> getServicioDisponibleByInformeId(Long informeId);
}