package com.axiomasoluciones.app.bafrau.application.serviceImplement.utility;

import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.utility.AdjuntoIMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Caratula;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Seccion;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.CaratulaRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.EncabezadoRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.SeccionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.utility.AdjuntoRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.OrganizacionRepository;
import com.axiomasoluciones.app.bafrau.domain.services.utility.AdjuntoService;

import com.axiomasoluciones.app.bafrau.insfrastructure.claudinary.CloudinaryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    private CloudinaryService cloudinaryService;

    @Autowired
    private AdjuntoRepository adjuntoRepo;

    @Autowired
    private SeccionRepository seccionRepo;

    @Autowired private
    AdjuntoIMapper mapper;

    @Autowired
    private EncabezadoRepository encabezadoRepository;

    @Autowired
    private CaratulaRepository caratulaRepository;

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
    public List<AdjuntoDTO> getAdjuntosByOrganizacionId(Long organizacionId) {
        List<Adjunto> adjuntos = adjuntoRepository.findByOrganizacionId(organizacionId);
        return adjuntos.stream()
                .map(adjuntoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AdjuntoDTO saveToSeccion(MultipartFile file,
                                    String descripcion,
                                    Long seccionId) {
        // 1) Buscá la sección
        Seccion seccion = seccionRepo.findById(seccionId)
                .orElseThrow(() -> new EntityNotFoundException("Sección no encontrada: " + seccionId));

        // 2) Subí el archivo a Cloudinary y obtené la URL
        String urlAdjunto;
        try {
            Map<String, String> uploadResult = cloudinaryService.upload(file);
            urlAdjunto = uploadResult.get("url");  // asegúrate de que la clave sea "url"
        } catch (IOException e) {
            throw new RuntimeException("Error al subir el archivo a Cloudinary", e);
        }

        // 3) Creá el Adjunto y asocialo a la sección
        Adjunto adj = new Adjunto();
        adj.setUrlAdjunto(urlAdjunto);
        adj.setDescripcion(descripcion);
        adj.setSeccion(seccion);

        // 4) Guardá y devolvé DTO
        Adjunto saved = adjuntoRepo.save(adj);
        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Adjunto adj = adjuntoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adjunto no encontrado con ID: " + id));
        adjuntoRepository.delete(adj);
    }

    @Override
    @Transactional
    public AdjuntoDTO saveToEncabezado(MultipartFile file,
                                       String descripcion,
                                       Long encabezadoId) {
        // 1) Buscamos el Encabezado
        var encabezado = encabezadoRepository.findById(encabezadoId)
                .orElseThrow(() -> new EntityNotFoundException("Encabezado no encontrado: " + encabezadoId));
        // 2) Subimos a Cloudinary
        String url;
        try {
            Map<String,String> res = cloudinaryService.upload(file);
            url = res.get("url");
        } catch (IOException e) {
            throw new RuntimeException("Error al subir archivo", e);
        }
        // 3) Creamos y asociamos el Adjunto
        Adjunto adj = new Adjunto();
        adj.setUrlAdjunto(url);
        adj.setDescripcion(descripcion);
        adj.setEncabezado(encabezado);
        // 4) Guardamos y devolvemos DTO
        return mapper.toDto(adjuntoRepository.save(adj));
    }

    @Override
    @Transactional
    public AdjuntoDTO saveToCaratula(MultipartFile file,
                                     String descripcion,
                                     Long caratulaId) {
        // 1) Buscar la carátula
        Caratula car = caratulaRepository.findById(caratulaId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Carátula no encontrada con ID: " + caratulaId)
                );

        // 2) Subir el archivo a Cloudinary
        String url;
        try {
            Map<String, String> res = cloudinaryService.upload(file);
            url = res.get("url");
        } catch (IOException e) {
            throw new RuntimeException("Error al subir archivo a Cloudinary", e);
        }

        // 3) Crear el adjunto y asociarlo a la carátula
        Adjunto adj = new Adjunto();
        adj.setUrlAdjunto(url);
        adj.setDescripcion(descripcion);
        adj.setCaratula(car);  // <-- setear la relación

        // 4) Guardar y devolver DTO
        Adjunto saved = adjuntoRepository.save(adj);
        return adjuntoMapper.toDto(saved);
    }
}