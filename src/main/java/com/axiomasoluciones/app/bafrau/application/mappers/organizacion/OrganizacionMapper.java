package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.user.UserMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ProcesoMapper.class, ProcedimientoMapper.class})
public interface OrganizacionMapper {

 @Mapping(source = "user.id", target = "userId")
 OrganizacionDTO toOrganizacionDTO(Organizacion organizacion);

 @Mapping(source = "userId", target = "user.id")
 Organizacion toOrganizacion(OrganizacionDTO organizacionDTO);

 // Ignorar el campo id en la actualización parcial
 @Mapping(target = "id", ignore = true)
 void partialUpdate(OrganizacionDTO source, @MappingTarget Organizacion target);
}
