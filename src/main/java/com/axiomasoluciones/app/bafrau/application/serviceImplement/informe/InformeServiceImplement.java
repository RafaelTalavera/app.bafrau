package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InformeDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.InformeMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import com.axiomasoluciones.app.bafrau.domain.entities.user.User;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.InformeRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.user.UserRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.IInformeService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InformeServiceImplement implements IInformeService {

    @Autowired
    private InformeRepository informeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InformeMapper informeMapper;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    @Override
    public List<InformeDTO> findAll() {
        List<Informe> informes = StreamSupport
                .stream(informeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return informes.stream()
                .map(informeMapper::toInformeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InformeDTO> findById(Long id) {
        return informeRepository.findById(id)
                .map(informeMapper::toInformeDTO);
    }

    @Override
    public InformeDTO create(InformeDTO informeDTO, String token) {
        // Extraer el userId desde el token
        Long userId = extractUserIdFromToken(token);  // Obtener userId del token
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            Informe informe = informeMapper.toInforme(informeDTO);
            informe.setUser(user.get());  // Asociar el informe al usuario extraído del token
            Informe savedInforme = informeRepository.save(informe);
            return informeMapper.toInformeDTO(savedInforme);
        }
        throw new IllegalArgumentException("No se encontró el usuario asociado con el informe");
    }


    @Override
    public InformeDTO update(Long id, InformeDTO informeDTO) {
        System.out.println("Entrando a update con ID: " + id);
        System.out.println("Datos del informeDTO: " + informeDTO);

        return informeRepository.findById(id).map(existingInforme -> {
            // Resetear el ID en informeDTO para evitar sobrescribir
            informeDTO.setId(null);

            System.out.println("Datos antes de partialUpdate: " + existingInforme);

            informeMapper.partialUpdate(informeDTO, existingInforme); // Actualizar campos editados

            Long userId = informeDTO.getUserId();
            if (userId != null) {
                userRepository.findById(userId).ifPresent(existingInforme::setUser);
            }

            System.out.println("Datos después de partialUpdate: " + existingInforme);

            Informe updatedInforme = informeRepository.save(existingInforme);
            System.out.println("Informe actualizado: " + updatedInforme);

            return informeMapper.toInformeDTO(updatedInforme);
        }).orElseThrow(() -> new IllegalArgumentException("No se encontró el informe a actualizar"));
    }


    @Override
    public void deleteById(Long id) {
        Optional<Informe> existingInforme = informeRepository.findById(id);

        if (existingInforme.isPresent()) {
            informeRepository.deleteById(id);  // Elimina el informe
        } else {
            throw new IllegalArgumentException("No se encontró el informe a eliminar");
        }
    }

    public Long extractUserIdFromToken(String token) {
        try {
            String jwtToken = token.replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
            Long userId = claims.get("userId", Long.class);
            System.out.println("User ID extraído del token: " + userId);
            return userId;
        } catch (Exception e) {
            throw new RuntimeException("Error al extraer el user ID del token", e);
        }
    }

    public String extractOrganizacionFromToken(String token) {
        try{
            String jwtToken = token.replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
            String organizacion = claims.get("organizacion",String.class);
            System.out.println("La organizacion extraida del token es: " + organizacion);
            return organizacion;
        } catch (Exception e) {
            throw new RuntimeException("Error al extraer la organizacion del token", e);
        }
        }


    @Override
    public List<InformeDTO> findByOrganizacion(String organizacion) {
        List<Informe> informes = informeRepository.findAllByUserOrganizacion(organizacion);
        return informes.stream()
                .map(informeMapper::toInformeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InformeDTO> obtenerRazonesSociales() {
        List<Object[]> resultados = informeRepository.findAllRazonesSociales();
        return resultados.stream()
                .map(obj -> new InformeDTO((Long) obj[0], (String) obj[1])) // Mapea a InformeDTO
                .collect(Collectors.toList());
    }

}

