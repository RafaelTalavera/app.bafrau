package com.axiomasoluciones.app.bafrau.services.implement;

import com.axiomasoluciones.app.bafrau.dto.request.InformeRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.request.ItemInformeDTO;
import com.axiomasoluciones.app.bafrau.dto.response.InformeResponseDTO;
import com.axiomasoluciones.app.bafrau.models.dao.InformeRepository;
import com.axiomasoluciones.app.bafrau.models.dao.MatrizRepository;
import com.axiomasoluciones.app.bafrau.models.dao.UserRepository;
import com.axiomasoluciones.app.bafrau.models.entities.Informe;
import com.axiomasoluciones.app.bafrau.models.entities.ItemInforme;
import com.axiomasoluciones.app.bafrau.models.entities.Matriz;
import com.axiomasoluciones.app.bafrau.models.entities.User;
import com.axiomasoluciones.app.bafrau.services.IInformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformeServiceImplements implements IInformeService {

    @Autowired
    private InformeRepository informeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatrizRepository matrizRepository;

    @Override
    public List<Informe> findAll() {
        return null;
    }

    @Override
    public InformeResponseDTO createInforme(InformeRequestDTO informeRequestDTO) {
        User user = userRepository.findById(informeRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Informe informe = new Informe();
        informe.setFecha(informeRequestDTO.getFecha());
        informe.setOrganizacion(informeRequestDTO.getOrganizacion());
        informe.setDireccion(informeRequestDTO.getDireccion());
        informe.setRubro(informeRequestDTO.getRubro());
        informe.setUser(user);

        List<ItemInforme> items = informeRequestDTO.getItems().stream().map(itemDTO -> {
            Matriz matriz = matrizRepository.findById(itemDTO.getMatrizId())
                    .orElseThrow(() -> new RuntimeException("Matriz not found"));

            ItemInforme itemInforme = new ItemInforme();
            itemInforme.setMagnitude(itemDTO.getMagnitude());
            itemInforme.setImportance(itemDTO.getImportance());
            itemInforme.setMatriz(matriz);
            itemInforme.setInforme(informe);
            return itemInforme;
        }).collect(Collectors.toList());

        informe.setItems(items);

        Informe savedInforme = informeRepository.save(informe);

        return new InformeResponseDTO(
                savedInforme.getId(),
                savedInforme.getFecha(),
                savedInforme.getOrganizacion(),
                savedInforme.getDireccion(),
                savedInforme.getRubro(),
                items.stream().map(item -> new ItemInformeDTO(
                        item.getMagnitude(),
                        item.getImportance(),
                        item.getMatriz().getId()
                )).collect(Collectors.toList())
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