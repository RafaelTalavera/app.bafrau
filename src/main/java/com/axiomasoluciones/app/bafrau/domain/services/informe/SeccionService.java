package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.OrdenSeccionDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.SeccionDTO;
import java.util.List;

public interface SeccionService {

    List<SeccionDTO> findAll();

    SeccionDTO findById(Long id);

    SeccionDTO create(SeccionDTO seccionDTO);

    SeccionDTO update(Long id, SeccionDTO seccionDTO);

    void delete(Long id);

    void updateOrdenes(List<OrdenSeccionDTO> ordenes);

}
