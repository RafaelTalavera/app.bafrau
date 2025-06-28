package com.axiomasoluciones.app.bafrau.domain.services.utility;


import com.axiomasoluciones.app.bafrau.application.dto.utility.StyleTemplateDTO;

import java.util.List;

public interface StyleTemplateService {

    List<StyleTemplateDTO> findAll();

    StyleTemplateDTO findeById(Long id);

    StyleTemplateDTO save(StyleTemplateDTO styleTemplateDTO);

    StyleTemplateDTO update(Long id, StyleTemplateDTO styleTemplateDTO);

    void deleteById(Long id);

}
