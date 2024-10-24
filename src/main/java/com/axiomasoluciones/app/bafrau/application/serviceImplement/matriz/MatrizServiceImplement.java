package com.axiomasoluciones.app.bafrau.application.serviceImplement.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.MatrizDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.matriz.MatrizMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.seccion.Seccion;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Matriz;
import com.axiomasoluciones.app.bafrau.domain.entities.user.User;
import com.axiomasoluciones.app.bafrau.domain.repository.matriz.MatrizRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.seccion.SeccionRepository;
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
    private SeccionRepository seccionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatrizMapper matrizMapper;

    @Override
    public List<MatrizDTO> findAll() {
        List<Matriz> matrices = StreamSupport
                .stream(matrizRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return matrices.stream()
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
        // Asegurarse de que la matriz esté asociada a una sección existente
        Long seccionId = matrizDTO.getSeccionId();
        Optional<Seccion> seccion = seccionRepository.findById(seccionId);

        Long userId = matrizDTO.getUserId();  // Verificar que la matriz esté asociada a un usuario
        Optional<User> user = userRepository.findById(userId);

        if (seccion.isPresent() && user.isPresent()) {
            Matriz matriz = matrizMapper.toMatriz(matrizDTO);
            matriz.setSeccion(seccion.get());  // Asociar la matriz a la sección
            matriz.setUser(user.get());        // Asociar la matriz al usuario
            Matriz savedMatriz = matrizRepository.save(matriz);
            return matrizMapper.toMatrizDTO(savedMatriz);
        }
        throw new IllegalArgumentException("No se encontró la sección o el usuario asociado con la matriz");
    }

    @Override
    public MatrizDTO update(Long id, MatrizDTO matrizDTO) {
        Optional<Matriz> existingMatriz = matrizRepository.findById(id);
        if (existingMatriz.isPresent()) {
            Matriz matriz = matrizMapper.toMatriz(matrizDTO);
            matriz.setId(id);
            Matriz updatedMatriz = matrizRepository.save(matriz);
            return matrizMapper.toMatrizDTO(updatedMatriz);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        matrizRepository.deleteById(id);
    }
}
