package com.axiomasoluciones.app.bafrau.application.serviceImplement.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.ItemUIPUpdateDTO;
import com.axiomasoluciones.app.bafrau.application.dto.matriz.MatrizDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.matriz.ItemMatrizMapper;
import com.axiomasoluciones.app.bafrau.application.mappers.matriz.MatrizMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.ItemMatriz;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Matriz;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.repository.matriz.AccionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.matriz.FactorRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.matriz.MatrizRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.OrganizacionRepository;
import com.axiomasoluciones.app.bafrau.domain.services.matriz.IMatrizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatrizServiceImplement implements IMatrizService {

    @Autowired
    private MatrizRepository matrizRepository;

    @Autowired
    private OrganizacionRepository organizacionRepository;

    @Autowired
    private MatrizMapper matrizMapper;

    @Autowired
    private ItemMatrizMapper itemMatrizMapper;

    @Autowired
    private AccionRepository accionRepository;

    @Autowired
    private FactorRepository factorRepository;

    private static final Logger log =
            LoggerFactory.getLogger(MatrizServiceImplement.class);

    @Override
    @Transactional(readOnly = true)
    public List<MatrizDTO> findAll() {
        return matrizRepository.findAllWithItems().stream()
                .map(entity -> {
                    MatrizDTO dto = matrizMapper.toMatrizDTO(entity);
                    dto.setOrganizacionNombre(entity.getOrganizacion().getRazonSocial());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MatrizDTO> findById(Long id) {
        return matrizRepository.findByIdWithItems(id)
                .map(entity -> {
                    MatrizDTO dto = matrizMapper.toMatrizDTO(entity);
                    dto.setOrganizacionNombre(entity.getOrganizacion().getRazonSocial());
                    return dto;
                });
    }

    @Override
    @Transactional
    public MatrizDTO create(MatrizDTO matrizDTO) {
        // 1) validar que venga organizationId
        if (matrizDTO.getOrganizacionId() == null) {
            throw new IllegalArgumentException("Debe indicar organización");
        }
        Organizacion org = organizacionRepository.findById(matrizDTO.getOrganizacionId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Organización no encontrada: " + matrizDTO.getOrganizacionId()));

        // 2) mapear DTO a entidad (sin user)
        Matriz matriz = matrizMapper.toMatriz(matrizDTO);
        matriz.setOrganizacion(org);
        // NO setUser(...)

        // 3) mapear y enlazar items, validando que los IDs no sean nulos
        if (!CollectionUtils.isEmpty(matrizDTO.getItems())) {
            List<ItemMatriz> items = matrizDTO.getItems().stream().map(dto -> {
                ItemMatriz it = itemMatrizMapper.toItemMatriz(dto);
                it.setMatriz(matriz);
                if (dto.getAccionId() != null) {
                    accionRepository.findById(dto.getAccionId()).ifPresent(it::setAccion);
                }
                if (dto.getFactorId() != null) {
                    factorRepository.findById(dto.getFactorId()).ifPresent(it::setFactor);
                }
                return it;
            }).collect(Collectors.toList());
            matriz.setItems(items);
        }

        // 4) guardar y devolver DTO
        Matriz saved = matrizRepository.save(matriz);
        MatrizDTO result = matrizMapper.toMatrizDTO(saved);
        result.setOrganizacionNombre(saved.getOrganizacion().getRazonSocial());
        return result;
    }

    @Override
    @Transactional
    public MatrizDTO update(Long id, MatrizDTO matrizDTO) {
        log.info("▶ Ejecutando update(id={}, matrizDTO={})", id, matrizDTO);

        return matrizRepository.findById(id)
                .map(existing -> {
                    // 1) Mapear DTO a entidad y asegurar el ID
                    Matriz toSave = matrizMapper.toMatriz(matrizDTO);
                    toSave.setId(id);

                    // 2) Vincular cada ItemMatriz con su padre
                    if (toSave.getItems() != null) {
                        toSave.getItems().forEach(item -> item.setMatriz(toSave));
                    }

                    // 3) Guardar en BD
                    Matriz saved = matrizRepository.save(toSave);
                    log.debug("✔ Entidad Matriz e Items vinculados y guardados para id={}", id);

                    // 4) Mapear de vuelta a DTO y ajustar campos adicionales
                    MatrizDTO dto = matrizMapper.toMatrizDTO(saved);
                    dto.setOrganizacionNombre(saved.getOrganizacion().getRazonSocial());

                    // 5) Forzar carga de items (si usas lazy loading)
                    dto.getItems().size();

                    log.info("✔ update completado para id={}", id);
                    return dto;
                })
                .orElseThrow(() -> {
                    log.warn("✖ Matriz no encontrada con id={}", id);
                    return new IllegalArgumentException("Matriz no encontrada con id " + id);
                });
    }


    @Override
    public void deleteById(Long id) {
        matrizRepository.deleteById(id);
    }

    @Override
    @Transactional
    public MatrizDTO updateUIP(Long matrizId, List<ItemUIPUpdateDTO> updates) {
        Matriz matriz = matrizRepository.findByIdWithItems(matrizId)
                .orElseThrow(() -> new IllegalArgumentException("Matriz no encontrada: " + matrizId));

        updates.forEach(dto -> {
            System.out.println("DEBUG updateUIP dto: itemId=" + dto.getItemId() + ", uip=" + dto.getUip());
            matriz.getItems().stream()
                    .filter(item -> item.getId().equals(dto.getItemId()))
                    .findFirst()
                    .ifPresent(item -> {
                        System.out.println("  antes uIP=" + item.getUip());
                        item.setUip(dto.getUip());
                        System.out.println("  después uIP=" + item.getUip());
                    });
        });

        Matriz saved = matrizRepository.save(matriz);
        MatrizDTO result = matrizMapper.toMatrizDTO(saved);
        result.setOrganizacionNombre(saved.getOrganizacion().getRazonSocial());
        return result;
    }

}
