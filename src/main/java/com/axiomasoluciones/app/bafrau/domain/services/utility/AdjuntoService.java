package com.axiomasoluciones.app.bafrau.domain.services.utility;

import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdjuntoService {

    List<AdjuntoDTO> findAll();

    AdjuntoDTO findById(Long id);

    AdjuntoDTO save(MultipartFile file, String descripcion, Long organizacionId);

    AdjuntoDTO update(Long id, MultipartFile file, String descripcion);

    void deleteById(Long id);

    List<AdjuntoDTO> getAdjuntosByOrganizacionId(Long organizacionId);

    AdjuntoDTO saveToSeccion(MultipartFile file, String descripcion, Long seccionId);

    AdjuntoDTO saveToEncabezado(MultipartFile file, String descripcion, Long encabezadoId);

    AdjuntoDTO saveToCaratula(MultipartFile file, String descripcion, Long caratulaId);

}