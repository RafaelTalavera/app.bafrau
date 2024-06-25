package com.axiomasoluciones.app.bafrau.services;

import com.axiomasoluciones.app.bafrau.dto.request.MatrizRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.MatrizResponseDTO;
import com.axiomasoluciones.app.bafrau.dto.response.UserResponseDTO;
import com.axiomasoluciones.app.bafrau.models.entities.Matriz;

import java.util.List;
import java.util.Optional;

public interface IMatrizService {

    public List<MatrizResponseDTO> findAll();

    MatrizResponseDTO createMatriz(MatrizRequestDTO  matrizRequestDTO);

    Optional<MatrizResponseDTO> findById(Long id);

    public void delete(Long id);

}
