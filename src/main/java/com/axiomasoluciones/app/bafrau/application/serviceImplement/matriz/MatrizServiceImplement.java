package com.axiomasoluciones.app.bafrau.application.serviceImplement.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.MatrizDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.matriz.MatrizMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Matriz;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.entities.user.User;
import com.axiomasoluciones.app.bafrau.domain.repository.matriz.MatrizRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.OrganizacionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.user.UserRepository;
import com.axiomasoluciones.app.bafrau.domain.services.matriz.IMatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MatrizServiceImplement implements IMatrizService {

    @Autowired
    private MatrizRepository matrizRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizacionRepository organizacionRepository;

    @Autowired
    private MatrizMapper matrizMapper;

    @Override
    public List<MatrizDTO> findAll() {
        return StreamSupport.stream(matrizRepository.findAll().spliterator(), false)
                .map(matrizMapper::toMatrizDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MatrizDTO> findById(Long id) {
        return matrizRepository.findById(id)
                .map(matrizMapper::toMatrizDTO);
    }

    @Override
    public MatrizDTO create(MatrizDTO matrizDTO) {
        Long orgId = matrizDTO.getOrganizacionId();
        if (orgId == null) {
            throw new IllegalArgumentException("La organizaciónId no está presente");
        }

        Organizacion org = organizacionRepository.findById(orgId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "La organización con id " + orgId + " no existe"));

        Long userId = matrizDTO.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "El usuario con id " + userId + " no existe"));

        Matriz matriz = matrizMapper.toMatriz(matrizDTO);
        matriz.setOrganizacion(org);
        matriz.setUser(user);

        Matriz saved = matrizRepository.save(matriz);
        return matrizMapper.toMatrizDTO(saved);
    }

    @Override
    public MatrizDTO update(Long id, MatrizDTO matrizDTO) {
        return matrizRepository.findById(id)
                .map(existing -> {
                    Matriz matriz = matrizMapper.toMatriz(matrizDTO);
                    matriz.setId(id);
                    return matrizMapper.toMatrizDTO(matrizRepository.save(matriz));
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        matrizRepository.deleteById(id);
    }
}
