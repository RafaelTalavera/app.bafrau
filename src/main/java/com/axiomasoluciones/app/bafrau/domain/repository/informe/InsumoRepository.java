package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Insumo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsumoRepository extends CrudRepository<Insumo, Long> {

    List<Insumo> findByProceso_Id(Long procesoId);

    List<Insumo> findByProcesoInformeId(Long informeId);

}
