package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.ProcesoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Proceso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {InsumoMapper.class, InformeMapper.class})
public interface ProcesoMapper {

    @Mapping(source = "informe.id", target = "informeId")  // Mapear informe.id a informeId en el DTO
    ProcesoDTO toProcesoDTO(Proceso proceso);

    @Mapping(source = "informeId", target = "informe.id")  // Mapear informeId del DTO a informe en la entidad
    Proceso toProceso(ProcesoDTO procesoDTO);
}

