package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CaratulaDTO;
import java.util.List;

public interface CaratulaService {
    List<CaratulaDTO> findAll();
    // --- CAMBIO: findByInformeId ---
    List<CaratulaDTO> findByInformeId(Long informeId);
    CaratulaDTO findById(Long id);
    // --- CAMBIO: create recibe informeId ---
    CaratulaDTO create(Long informeId, CaratulaDTO caratulaDTO);
    CaratulaDTO update(Long id, CaratulaDTO caratulaDTO);
    void delete(Long id);
}
