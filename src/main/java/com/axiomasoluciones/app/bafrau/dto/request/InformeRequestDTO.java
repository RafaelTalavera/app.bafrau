package com.axiomasoluciones.app.bafrau.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformeRequestDTO {
    private LocalDate fecha;
    private String organizacion;
    private String direccion;
    private String rubro;
    private Long userId;
    private List<ItemInformeDTO> items;
}
