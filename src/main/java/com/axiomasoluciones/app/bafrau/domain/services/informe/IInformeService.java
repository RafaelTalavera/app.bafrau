package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InformeDTO;

import java.util.List;
import java.util.Optional;

public interface IInformeService {

    List<InformeDTO> findAll();

    Optional<InformeDTO> findById(Long id);

    InformeDTO create(InformeDTO informeDTO, String token);

    InformeDTO update(Long id, InformeDTO informeDTO);

    void deleteById(Long id);

    List<InformeDTO> findByOrganizacion(String organizacion);

    String extractOrganizacionFromToken(String token);

    List<InformeDTO> obtenerRazonesSociales();

}