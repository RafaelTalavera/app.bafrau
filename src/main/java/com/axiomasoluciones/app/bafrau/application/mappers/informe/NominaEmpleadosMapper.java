package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.NominaEmpleadosDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.NominaEmpleados;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface NominaEmpleadosMapper {

    @Mapping(source = "informe.id", target = "informeId") // Mapea el ID del informe
    NominaEmpleadosDTO toNominaEmpleadosDTO(NominaEmpleados nominaEmpleados);

    @Mapping(source = "informeId", target = "informe.id") // Mapea el informeId del DTO a la entidad Informe
    NominaEmpleados toNominaEmpleados(NominaEmpleadosDTO nominaEmpleadosDTO);

    // Método para mapear una lista de NominaEmpleados a NominaEmpleadosDTO
    List<NominaEmpleadosDTO> toNominaEmpleadosDTOList(List<NominaEmpleados> nominaEmpleadosList);

    // Método para mapear una lista de NominaEmpleadosDTO a NominaEmpleados
    List<NominaEmpleados> toNominaEmpleadosList(List<NominaEmpleadosDTO> nominaEmpleadosDTOList);
}