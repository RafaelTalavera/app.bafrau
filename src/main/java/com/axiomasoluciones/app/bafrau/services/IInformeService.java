package com.axiomasoluciones.app.bafrau.services;

import com.axiomasoluciones.app.bafrau.dto.request.InformeRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.InformeResponseDTO;
import com.axiomasoluciones.app.bafrau.models.entities.Informe;


import java.util.List;

public interface IInformeService {

    public List<Informe> findAll();

    public InformeResponseDTO createInforme(InformeRequestDTO informeRequestDTO);

    public Informe findOne(Long id);

    public void delete(Long id);

}
