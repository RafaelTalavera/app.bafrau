package com.axiomasoluciones.app.bafrau.application.mappers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.ItemMatrizDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.ItemMatriz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMatrizMapper {

    @Mapping(source = "id",             target = "id")
    @Mapping(source = "etapa",          target = "etapa")
   // @Mapping(source = "razonSocial",    target = "razonSocial")
    @Mapping(source = "naturaleza",     target = "naturaleza")
    @Mapping(source = "intensidad",     target = "intensidad")
    @Mapping(source = "extension",      target = "extension")
    @Mapping(source = "momento",        target = "momento")
    @Mapping(source = "persistencia",   target = "persistencia")
    @Mapping(source = "reversivilidad", target = "reversivilidad")
    @Mapping(source = "sinergia",       target = "sinergia")
    @Mapping(source = "acumulacion",    target = "acumulacion")
    @Mapping(source = "efecto",         target = "efecto")
    @Mapping(source = "periodicidad",   target = "periodicidad")
    @Mapping(source = "recuperacion",   target = "recuperacion")
    @Mapping(source = "uip",            target = "uip")

    @Mapping(source = "magnitude",      target = "magnitude")
    @Mapping(source = "importance",     target = "importance")
    // relaciones
    @Mapping(source = "accion.id",       target = "accionId")
    @Mapping(source = "factor.id",       target = "factorId")
    @Mapping(source = "matriz.id",       target = "matrizId")
    // datos extraídos de factor
    @Mapping(source = "factor.sistema",        target = "factorSistema")
    @Mapping(source = "factor.subsistema",     target = "factorSubsistema")
    @Mapping(source = "factor.factor",         target = "factorFactor")
    @Mapping(source = "factor.componente",     target = "factorComponente")

    @Mapping(source = "matriz.organizacion.razonSocial", target = "razonSocial")

    @Mapping(source = "accion.tipo",     target = "accionTipo")
    ItemMatrizDTO toItemMatrizDTO(ItemMatriz item);

    // sólo para POST/PUT; no necesitas mapear matrizId al crear
    @Mapping(source = "accionId", target = "accion.id")
    @Mapping(source = "factorId", target = "factor.id")
    ItemMatriz toItemMatriz(ItemMatrizDTO dto);
}
