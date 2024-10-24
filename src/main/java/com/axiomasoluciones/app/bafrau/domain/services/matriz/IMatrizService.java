package com.axiomasoluciones.app.bafrau.domain.services.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.MatrizDTO;

import java.util.List;
import java.util.Optional;

public interface IMatrizService {
    List<MatrizDTO> findAll();
    Optional<MatrizDTO> findById(Long id);
    MatrizDTO create(MatrizDTO matrizDTO);
    MatrizDTO update(Long id, MatrizDTO matrizDTO);
    void deleteById(Long id);
}
