package com.axiomasoluciones.app.bafrau.services;

import com.axiomasoluciones.app.bafrau.dto.request.AccionRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.request.FactorRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.AccionResponseDTO;
import com.axiomasoluciones.app.bafrau.dto.response.FactorResponseDTO;
import com.axiomasoluciones.app.bafrau.models.entities.Factor;

import java.util.List;
import java.util.Optional;

public interface IFactorService {
    public List<FactorResponseDTO> findAll();
    Optional<FactorResponseDTO> findById(Long id);
    FactorResponseDTO createFactor(FactorRequestDTO factorRequestDTO);
    public void deleteById(Long id);
    FactorResponseDTO editedUser(Long id, FactorRequestDTO editedFactorRequestDTO);

    public List<FactorResponseDTO> findByClasificacion(String clasificacion);


}
