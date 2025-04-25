package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ProcesoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Proceso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {InsumoMapper.class, OrganizacionMapper.class})
public interface ProcesoMapper {

    @Mapping(source = "organizacion.id", target = "organizacionId")  // Mapear informe.id a informeId en el DTO
    ProcesoDTO toProcesoDTO(Proceso proceso);

    @Mapping(source = "organizacionId", target = "organizacion.id")  // Mapear informeId del DTO a informe en la entidad
    Proceso toProceso(ProcesoDTO procesoDTO);
}

