package com.axiomasoluciones.app.bafrau.dto.response;

import com.axiomasoluciones.app.bafrau.dto.request.ItemInformeDTO;
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
public class InformeResponseDTO {
    private Long id;
    private LocalDate fecha;
    private String organizacion;
    private String direccion;
    private String rubro;
    private List<ItemInformeDTO> items;
}
