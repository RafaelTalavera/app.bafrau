package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.NominaEmpleadosDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.NominaEmpleados;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface NominaEmpleadosMapper {

    @Mapping(source = "organizacion.id", target = "organizacionId")
    NominaEmpleadosDTO toNominaEmpleadosDTO(NominaEmpleados nominaEmpleados);

    @Mapping(source = "organizacionId", target = "organizacion.id")
    NominaEmpleados toNominaEmpleados(NominaEmpleadosDTO nominaEmpleadosDTO);

    // Método para mapear una lista de NominaEmpleados a NominaEmpleadosDTO
    List<NominaEmpleadosDTO> toNominaEmpleadosDTOList(List<NominaEmpleados> nominaEmpleadosList);

    // Método para mapear una lista de NominaEmpleadosDTO a NominaEmpleados
    List<NominaEmpleados> toNominaEmpleadosList(List<NominaEmpleadosDTO> nominaEmpleadosDTOList);
}