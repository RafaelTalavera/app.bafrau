package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InsumoDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.ProcesoDTO;

import java.util.List;

public interface InsumoService {

    List<InsumoDTO> findAll();  // Obtener todos los insumos

    InsumoDTO findById(Long id);  // Obtener un insumo por su ID

    InsumoDTO save(InsumoDTO insumoDTO);  // Crear un nuevo insumo

    InsumoDTO update(Long id, InsumoDTO insumoDTO);  // Actualizar un insumo

    void deleteById(Long id);  // Eliminar un insumo por su ID

    List<InsumoDTO> getInsumosByProcesoId(Long procesoId);

    List<InsumoDTO> getInsumoByInformeId(Long informeId);
}

