package com.axiomasoluciones.app.bafrau.application.serviceImplement.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.organizacion.OrganizacionMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.entities.user.User;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.OrganizacionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.user.UserRepository;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.OrganizacionService;
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
public class OrganizacionServiceImplement implements OrganizacionService {

    @Autowired
    private OrganizacionRepository organizacionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizacionMapper organizacionMapper;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    @Override
    public List<OrganizacionDTO> findAll() {
        List<Organizacion> organizaciones = StreamSupport
                .stream(organizacionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return organizaciones.stream()
                .map(organizacionMapper::toOrganizacionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OrganizacionDTO> findById(Long id) {
        return organizacionRepository.findById(id)
                .map(organizacionMapper::toOrganizacionDTO);
    }

    @Override
    public OrganizacionDTO create(OrganizacionDTO organizacionDTO, String token) {
        Long userId = extractUserIdFromToken(token);
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            Organizacion organizacion = organizacionMapper.toOrganizacion(organizacionDTO);
            organizacion.setUser(user.get());
            Organizacion savedOrganizacion = organizacionRepository.save(organizacion);
            return organizacionMapper.toOrganizacionDTO(savedOrganizacion);
        }
        throw new IllegalArgumentException("No se encontró el usuario asociado con el informe");
    }


    @Override
    public OrganizacionDTO update(Long id, OrganizacionDTO organizacionDTO) {
        System.out.println("Entrando a update con ID: " + id);
        System.out.println("Datos del organizacionDTO: " + organizacionDTO);

        return organizacionRepository.findById(id).map(existingOrganizacion -> {
            organizacionDTO.setId(null);
            System.out.println("Datos antes de partialUpdate: " + existingOrganizacion);
            organizacionMapper.partialUpdate(organizacionDTO, existingOrganizacion);
            Long userId = organizacionDTO.getUserId();
            if (userId != null) {
                userRepository.findById(userId).ifPresent(existingOrganizacion::setUser);
            }
            System.out.println("Datos después de partialUpdate: " + existingOrganizacion);
            Organizacion updatedOrganizacion = organizacionRepository.save(existingOrganizacion);
            System.out.println("Informe actualizado: " + updatedOrganizacion);

            return organizacionMapper.toOrganizacionDTO(updatedOrganizacion);
        }).orElseThrow(() -> new IllegalArgumentException("No se encontró el informe a actualizar"));
    }


    @Override
    public void deleteById(Long id) {
        Optional<Organizacion> existingOrganizacion = organizacionRepository.findById(id);

        if (existingOrganizacion.isPresent()) {
            organizacionRepository.deleteById(id);  // Elimina el informe
        } else {
            throw new IllegalArgumentException("No se encontró la organización a eliminar");
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
    public List<OrganizacionDTO> findByOrganizacion(String organizacion) {
        List<Organizacion> organizaciones = organizacionRepository.findAllByUserOrganizacion(organizacion);
        return organizaciones.stream()
                .map(organizacionMapper::toOrganizacionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrganizacionDTO> obtenerRazonesSociales() {
        List<Object[]> resultados = organizacionRepository.findAllRazonesSociales();
        return resultados.stream()
                .map(obj -> {
                    OrganizacionDTO dto = new OrganizacionDTO();
                    dto.setId((Long) obj[0]);
                    dto.setRazonSocial((String) obj[1]);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<OrganizacionDTO> findByTipoDeContrato(String tipoDeContrato) {
        List<Organizacion> list = organizacionRepository.findAllByTipoDeContrato(tipoDeContrato);
        return list.stream()
                .map(organizacionMapper::toOrganizacionDTO)
                .collect(Collectors.toList());
    }

}

