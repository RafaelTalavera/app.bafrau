package com.axiomasoluciones.app.bafrau.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FactorResponseDTO {
    private Long id;
    private String clasificacion;
    private String tipo;
}
