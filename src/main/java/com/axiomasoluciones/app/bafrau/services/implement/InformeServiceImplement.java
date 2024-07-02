package com.axiomasoluciones.app.bafrau.services.implement;

import com.axiomasoluciones.app.bafrau.dto.request.InformeRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.request.ItemInformeDTO;
import com.axiomasoluciones.app.bafrau.dto.response.InformeResponseDTO;
import com.axiomasoluciones.app.bafrau.models.dao.AccionRepository;
import com.axiomasoluciones.app.bafrau.models.dao.FactorRepository;
import com.axiomasoluciones.app.bafrau.models.dao.InformeRepository;
import com.axiomasoluciones.app.bafrau.models.dao.UserRepository;
import com.axiomasoluciones.app.bafrau.models.entities.*;
import com.axiomasoluciones.app.bafrau.services.IInformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformeServiceImplement implements IInformeService {

    @Autowired
    private InformeRepository informeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccionRepository accionRepository;

    @Autowired
    private FactorRepository factorRepository;

    @Override
    public List<Informe> findAll() {
        return null;
    }

    @Override
    public InformeResponseDTO createInforme(InformeRequestDTO informeRequestDTO, Long userId) {
        System.out.println("Starting createInforme method");

        // Check informeRequestDTO and its properties
        if (informeRequestDTO == null) {
            throw new RuntimeException("informeRequestDTO is null");
        }
        System.out.println("informeRequestDTO is not null");

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("User found: " + user.getId());

        Informe informe = new Informe();
        informe.setFecha(informeRequestDTO.getFecha());
        informe.setOrganizacion(informeRequestDTO.getOrganizacion());
        informe.setDireccion(informeRequestDTO.getDireccion());
        informe.setRubro(informeRequestDTO.getRubro());
        informe.setUser(user);

        List<ItemInforme> items = informeRequestDTO.getItems().stream().map(itemDTO -> {
            if (itemDTO.getAccionId() == null) {
                throw new RuntimeException("AccionId in itemDTO is null");
            }
            System.out.println("AccionId: " + itemDTO.getAccionId());

            Accion accion = accionRepository.findById(itemDTO.getAccionId())
                    .orElseThrow(() -> new RuntimeException("Accion not found"));
            System.out.println("Accion found: " + accion.getId());

            if (itemDTO.getFactorId() == null) {
                throw new RuntimeException("FactorId in itemDTO is null");
            }
            System.out.println("FactorId: " + itemDTO.getFactorId());

            Factor factor = factorRepository.findById(itemDTO.getFactorId())
                    .orElseThrow(() -> new RuntimeException("Factor not found"));
            System.out.println("Factor found: " + factor.getId());

            ItemInforme itemInforme = new ItemInforme();
            itemInforme.setMagnitude(itemDTO.getMagnitude());
            itemInforme.setImportance(itemDTO.getImportance());
            itemInforme.setAccion(accion);
            itemInforme.setFactor(factor);
            itemInforme.setInforme(informe);
            return itemInforme;
        }).collect(Collectors.toList());

        informe.setItems(items);

        Informe savedInforme = informeRepository.save(informe);
        System.out.println("Informe saved with ID: " + savedInforme.getId());

        List<ItemInformeDTO> itemInformeDTOs = items.stream().map(item -> new ItemInformeDTO(
                item.getMagnitude(),
                item.getImportance(),
                item.getAccion().getId(),
                item.getFactor().getId()
        )).collect(Collectors.toList());

        return new InformeResponseDTO(
                savedInforme.getId(),
                savedInforme.getFecha(),
                savedInforme.getOrganizacion(),
                savedInforme.getDireccion(),
                savedInforme.getRubro(),
                itemInformeDTOs
        );
    }
    @Override
    public Informe findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}