package com.axiomasoluciones.app.bafrau.application.serviceImplement.utility;

import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.utility.AdjuntoIMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.repository.utility.AdjuntoRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.OrganizacionRepository;
import com.axiomasoluciones.app.bafrau.domain.services.utility.AdjuntoService;

import com.axiomasoluciones.app.bafrau.insfrastructure.claudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdjuntoServiceImpl implements AdjuntoService {

    @Autowired
    private AdjuntoRepository adjuntoRepository;

    @Autowired
    private OrganizacionRepository informeRepository;

    @Autowired
    private AdjuntoIMapper adjuntoMapper;

    @Autowired
    private CloudinaryService cloudinaryService; // Servicio para manejar Cloudinary

    @Override
    public List<AdjuntoDTO> findAll() {
        return StreamSupport.stream(adjuntoRepository.findAll().spliterator(), false)
                .map(adjuntoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdjuntoDTO findById(Long id) {
        return adjuntoRepository.findById(id)
                .map(adjuntoMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Adjunto no encontrado con ID: " + id));
    }

    @Override
    public AdjuntoDTO save(MultipartFile file, String descripcion, Long organizacionId) {
        if (organizacionId == null) {
            throw new IllegalArgumentException("El ID de la organizacion es obligatorio para crear un adjunto informe.");
        }

        Organizacion organizacion = informeRepository.findById(organizacionId)
                .orElseThrow(() -> new IllegalArgumentException("La Organizacion no encontrado con ID: " + organizacionId));

        String urlAdjunto;
        try {
            Map<String, String> uploadResult = cloudinaryService.upload(file);
            urlAdjunto = uploadResult.get("url"); // Asegúrate de que "url" es la clave correcta para la URL en el resultado de Cloudinary
        } catch (IOException e) {
            throw new RuntimeException("Error al subir el archivo a Cloudinary", e);
        }

        Adjunto adjunto = new Adjunto();
        adjunto.setUrlAdjunto(urlAdjunto);
        adjunto.setDescripcion(descripcion);
        adjunto.setOrganizacion(organizacion);

        Adjunto savedAdjunto = adjuntoRepository.save(adjunto);
        return adjuntoMapper.toDto(savedAdjunto);
    }

    @Override
    public AdjuntoDTO update(Long id, MultipartFile file, String descripcion) {
        Adjunto adjuntoInforme = adjuntoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adjunto no encontrado con ID: " + id));
        if (file != null && !file.isEmpty()) {
            String urlAdjunto;
            try {
                Map<String, String> uploadResult = cloudinaryService.upload(file);
                urlAdjunto = uploadResult.get("url");
                adjuntoInforme.setUrlAdjunto(urlAdjunto);
            } catch (IOException e) {
                throw new RuntimeException("Error al subir el archivo a Cloudinary", e);
            }
        }
        if (descripcion != null) {
            adjuntoInforme.setDescripcion(descripcion);
        }
        Adjunto updatedAdjunto = adjuntoRepository.save(adjuntoInforme);
        return adjuntoMapper.toDto(updatedAdjunto);
    }


    @Override
    public void deleteById(Long id) {
        if (!adjuntoRepository.existsById(id)) {
            throw new RuntimeException("AdjuntoInforme no encontrado con ID: " + id);
        }
        adjuntoRepository.deleteById(id);
    }

    @Override
    public List<AdjuntoDTO> getAdjuntosByOrganizacionId(Long organizacionId) {
        List<Adjunto> adjuntos = adjuntoRepository.findByOrganizacionId(organizacionId);
        return adjuntos.stream()
                .map(adjuntoMapper::toDto)
                .collect(Collectors.toList());
    }
}