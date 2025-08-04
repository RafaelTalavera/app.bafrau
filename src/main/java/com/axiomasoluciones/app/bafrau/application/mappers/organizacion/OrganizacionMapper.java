package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.user.UserMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import org.mapstruct.*;
import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {UserMapper.class, ProcesoMapper.class, ProcedimientoMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OrganizacionMapper {

 @Mapping(source = "user.id", target = "userId")
 OrganizacionDTO toOrganizacionDTO(Organizacion organizacion);

 @Mapping(source = "userId", target = "user.id")
 Organizacion toOrganizacion(OrganizacionDTO organizacionDTO);

 @Mapping(target = "id", source = "id")
 @Mapping(target = "razonSocial", source = "razonSocial")
 @Named("simple")
 OrganizacionDTO toSimpleDTO(Organizacion organizacion);

 @IterableMapping(qualifiedByName = "simple")
 List<OrganizacionDTO> toSimpleDTOList(List<Organizacion> organizaciones);

 @Mapping(target = "id", ignore = true)
 void partialUpdate(OrganizacionDTO source, @MappingTarget Organizacion target);


 /**
  * Mapea únicamente un ID a la entidad para establecer la referencia.
  */
 @Named("mapOrganizacionFromId")
 default Organizacion mapOrganizacionFromId(Long id) {
  if (id == null) {
   return null;
  }
  Organizacion org = new Organizacion();
  org.setId(id);
  return org;
 }
}
