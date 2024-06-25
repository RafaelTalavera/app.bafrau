package com.axiomasoluciones.app.bafrau.services.implement;

import com.axiomasoluciones.app.bafrau.dto.request.MatrizRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.MatrizResponseDTO;
import com.axiomasoluciones.app.bafrau.models.dao.MatrizRepository;
import com.axiomasoluciones.app.bafrau.models.entities.Matriz;
import com.axiomasoluciones.app.bafrau.services.IMatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MatrizServiceImplements implements IMatrizService {

    @Autowired
    MatrizRepository matrizDao;

    @Override
    @Transactional(readOnly = true)
    public List<MatrizResponseDTO> findAll() {
        Iterable<Matriz> matrices = matrizDao.findAll();
        return StreamSupport.stream(matrices.spliterator(), false)
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MatrizResponseDTO createMatriz(MatrizRequestDTO matrizRequestDTO) {
        Matriz matriz = convertToEntity(matrizRequestDTO);
        Matriz savedMatriz = matrizDao.save(matriz);
        return convertToResponseDTO(savedMatriz);
    }

    @Override
    public Optional<MatrizResponseDTO> findById(Long id) {
        return matrizDao.findById(id).map(this::convertToResponseDTO);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        matrizDao.deleteById(id);
    }

    private MatrizResponseDTO convertToResponseDTO(Matriz matriz) {
        MatrizResponseDTO dto = new MatrizResponseDTO();
        dto.setId(matriz.getId());
        dto.setFactor(matriz.getFactor());
        dto.setAccion(matriz.getAccion());
        // Añadir cualquier otro campo necesario
        return dto;
    }

    private Matriz convertToEntity(MatrizRequestDTO dto) {
        Matriz matriz = new Matriz();
        matriz.setFactor(dto.getFactor());
        matriz.setAccion(dto.getAccion());
        // Añadir cualquier otro campo necesario
        return matriz;
    }
}
