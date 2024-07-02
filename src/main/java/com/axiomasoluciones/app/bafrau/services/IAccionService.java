package com.axiomasoluciones.app.bafrau.services;

import com.axiomasoluciones.app.bafrau.dto.request.AccionRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.AccionResponseDTO;
import com.axiomasoluciones.app.bafrau.models.entities.Accion;

import java.util.List;
import java.util.Optional;

public interface IAccionService {
    public List<AccionResponseDTO> findAll();
    Optional<AccionResponseDTO> findById(Long id);
    AccionResponseDTO createAccion(AccionRequestDTO accionRequestDTO);
    public void deleteById(Long id);
    AccionResponseDTO editedAccion(Long id, AccionRequestDTO editedAccionRequestDTO);
    public List<AccionResponseDTO> findByClasificacion(String clasificacion);
}
