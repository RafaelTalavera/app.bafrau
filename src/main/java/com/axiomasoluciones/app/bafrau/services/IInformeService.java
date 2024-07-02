package com.axiomasoluciones.app.bafrau.services;

import com.axiomasoluciones.app.bafrau.dto.request.InformeRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.InformeResponseDTO;
import com.axiomasoluciones.app.bafrau.models.entities.Informe;


import java.util.List;

public interface IInformeService {

    public List<Informe> findAll();

    InformeResponseDTO createInforme(InformeRequestDTO informeRequestDTO, Long userId);

    public Informe findOne(Long id);

    public void delete(Long id);

}
