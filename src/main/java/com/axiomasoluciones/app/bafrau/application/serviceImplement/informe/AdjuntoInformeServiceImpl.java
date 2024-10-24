package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.AdjuntoInformeDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.AdjuntoInformeMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.AdjuntoInforme;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.AdjuntoInformeRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.InformeRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.AdjuntoInformeService;

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
public class AdjuntoInformeServiceImpl implements AdjuntoInformeService {

    @Autowired
    private AdjuntoInformeRepository adjuntoInformeRepository;

    @Autowired
    private InformeRepository informeRepository;

    @Autowired
    private AdjuntoInformeMapper adjuntoInformeMapper;

    @Autowired
    private CloudinaryService cloudinaryService; // Servicio para manejar Cloudinary

    @Override
    public List<AdjuntoInformeDTO> findAll() {
        return StreamSupport.stream(adjuntoInformeRepository.findAll().spliterator(), false)
                .map(adjuntoInformeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdjuntoInformeDTO findById(Long id) {
        return adjuntoInformeRepository.findById(id)
                .map(adjuntoInformeMapper::toDto)
                .orElseThrow(() -> new RuntimeException("AdjuntoInforme no encontrado con ID: " + id));
    }

    @Override
    public AdjuntoInformeDTO save(MultipartFile file, String descripcion, Long informeId) {
        if (informeId == null) {
            throw new IllegalArgumentException("El ID del informe es obligatorio para crear un adjunto informe.");
        }

        // Buscar el informe relacionado
        Informe informe = informeRepository.findById(informeId)
                .orElseThrow(() -> new IllegalArgumentException("Informe no encontrado con ID: " + informeId));

        // Subir el archivo a Cloudinary y obtener la URL
        String urlAdjunto;
        try {
            Map<String, String> uploadResult = cloudinaryService.upload(file);
            urlAdjunto = uploadResult.get("url"); // Asegúrate de que "url" es la clave correcta para la URL en el resultado de Cloudinary
        } catch (IOException e) {
            throw new RuntimeException("Error al subir el archivo a Cloudinary", e);
        }

        AdjuntoInforme adjuntoInforme = new AdjuntoInforme();
        adjuntoInforme.setUrlAdjunto(urlAdjunto);
        adjuntoInforme.setDescripcion(descripcion);
        adjuntoInforme.setInforme(informe); // Asignar el informe relacionado

        AdjuntoInforme savedAdjunto = adjuntoInformeRepository.save(adjuntoInforme);
        return adjuntoInformeMapper.toDto(savedAdjunto);
    }

    @Override
    public AdjuntoInformeDTO update(Long id, MultipartFile file, String descripcion) {
        AdjuntoInforme adjuntoInforme = adjuntoInformeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AdjuntoInforme no encontrado con ID: " + id));

        if (file != null && !file.isEmpty()) {
            // Subir el nuevo archivo a Cloudinary y actualizar la URL
            String urlAdjunto;
            try {
                Map<String, String> uploadResult = cloudinaryService.upload(file);
                urlAdjunto = uploadResult.get("url"); // Asegúrate de que "url" es la clave correcta para la URL en el resultado de Cloudinary
                adjuntoInforme.setUrlAdjunto(urlAdjunto);
            } catch (IOException e) {
                throw new RuntimeException("Error al subir el archivo a Cloudinary", e);
            }
        }

        if (descripcion != null) {
            adjuntoInforme.setDescripcion(descripcion);
        }

        AdjuntoInforme updatedAdjunto = adjuntoInformeRepository.save(adjuntoInforme);
        return adjuntoInformeMapper.toDto(updatedAdjunto);
    }


    @Override
    public void deleteById(Long id) {
        if (!adjuntoInformeRepository.existsById(id)) {
            throw new RuntimeException("AdjuntoInforme no encontrado con ID: " + id);
        }
        adjuntoInformeRepository.deleteById(id);
    }

    @Override
    public List<AdjuntoInformeDTO> getAdjuntosByInformeId(Long informeId) {
        List<AdjuntoInforme> adjuntos = adjuntoInformeRepository.findByInformeId(informeId);
        return adjuntos.stream()
                .map(adjuntoInformeMapper::toDto)
                .collect(Collectors.toList());
    }
}