package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.AdjuntoInformeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdjuntoInformeService {

    List<AdjuntoInformeDTO> findAll();

    AdjuntoInformeDTO findById(Long id);

    AdjuntoInformeDTO save(MultipartFile file, String descripcion, Long informeId);

    AdjuntoInformeDTO update(Long id, MultipartFile file, String descripcion);

    void deleteById(Long id);

    List<AdjuntoInformeDTO> getAdjuntosByInformeId(Long informeId);
}