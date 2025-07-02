package com.axiomasoluciones.app.bafrau.application.serviceImplement.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ControlDTO;
import com.axiomasoluciones.app.bafrau.application.dto.legal.ItemControlDTO;
import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;
import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionSimpleDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.legal.ControlMapper;
import com.axiomasoluciones.app.bafrau.application.mappers.legal.ItemControlMapper;
import com.axiomasoluciones.app.bafrau.application.mappers.organizacion.OrganizacionMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.Control;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.ItemControl;
import com.axiomasoluciones.app.bafrau.domain.repository.legal.ControlRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.legal.ItemsControlRepository;
import com.axiomasoluciones.app.bafrau.domain.services.legal.ControlService;
import com.axiomasoluciones.app.bafrau.domain.services.utility.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ControlServiceImpl implements ControlService {

    private final ControlRepository repository;
    private final ControlMapper mapper;
    private final EmailService emailService;
    private final ItemsControlRepository itemsControlRepository;
    private static final Logger log = LoggerFactory.getLogger(ControlServiceImpl.class);
    private final ItemControlMapper itemControlMapper;
    private final OrganizacionMapper organizacionMapper;

    @Autowired
    public ControlServiceImpl(ControlRepository repository, ControlMapper mapper, EmailService emailService, ItemsControlRepository itemsControlRepository, ItemControlMapper itemControlMapper, OrganizacionMapper organizacionMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.emailService = emailService;
        this.itemsControlRepository = itemsControlRepository;
        this.itemControlMapper = itemControlMapper;
        this.organizacionMapper = organizacionMapper;
    }

    @Override
    public ControlDTO crearControl(ControlDTO dto) {
        Control control = mapper.toEntity(dto);
        control.getItems().forEach(item -> item.setControl(control));
        Control guardado = repository.save(control);
        return mapper.toDTO(guardado);
    }

    @Override
    public List<ControlDTO> obtenerTodos() {
        return repository.findAllWithItems().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public ControlDTO obtenerPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Control no encontrado"));
    }

    @Override
    public void eliminarControl(Long id) {
        Optional<Control> controlOpt = repository.findById(id);
        if (controlOpt.isPresent()) {
            repository.delete(controlOpt.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Control no encontrado");
        }
    }

    @Scheduled(cron = "0 0 9 * * ?", zone = "America/Argentina/Buenos_Aires")
    @Transactional(readOnly = true)
    public void checkAndSendNotifications() {
        // 1. Obtiene la fecha “hoy” según la zona horaria del servidor
        LocalDate today = LocalDate.now();

        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy");  // <— formateador

        // 2. Llama al repositorio para traer todos los ItemControl, incluyendo su lista de correos (listMail)
        //    La consulta @Query con "left join fetch i.listMail" ya trae en memoria cada conjunto de correos
        List<ItemControl> items = itemsControlRepository.findAllWithMails();

        // 3. Recorre cada ItemControl que vino de la base de datos
        for (ItemControl item : items) {
            // 3.1 Calcula cuántos días faltan para el vencimiento
            long daysRemaining = ChronoUnit.DAYS.between(today, item.getVencimiento());
            //    Ejemplo: si hoy es 2025-06-05 y vencimiento 2025-08-03, daysRemaining == 59

            // 3.2 Comprueba si el valor calculado coincide con el campo diasNotificacion en la entidad
            //    Solo en ese momento se debe enviar la notificación
            if (daysRemaining == item.getDiasNotificacion()) {
                // 4. Recupera el conjunto de correos (emails) de este ItemControl
                //    Esto ya está cargado porque findAllWithMails() hizo el “fetch”
                Set<String> mails = item.getListMail();

                // 4.1 Si no hay correos o la colección es nula, se salta este item
                if (mails == null || mails.isEmpty()) {
                    log.warn("ItemControl sin lista de emails: id={}", item.getId());
                    continue;  // Pasa al siguiente item sin enviar nada
                }

                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");  // <— formateador

                // 5. Construye el asunto y el cuerpo del mensaje
                String subject = "Importante: Notificacion de Vencimiento";
                String body = "Estimado cliente "
                        + item.getControl().getOrganizacion().getRazonSocial() + ",\n\n"
                        + "BAFRAU le informa que su \""
                        + item.getDocumento().getNombre() + "\""
                        + " vence el día "
                        + item.getVencimiento().format(fmt)  // <-- aquí formateas la fecha
                        + ". A la brevedad nos pondremos en contacto para la elaboración de la respuesta.";

                // 6. Recorre cada destinatario en la lista de correos
                for (String destinatario : mails) {
                    // 6.1 Valida que no sea null o cadena vacía
                    if (destinatario == null || destinatario.isBlank()) {
                        log.warn("Email inválido en ItemControl id={}", item.getId());
                        continue; // Salta este correo y sigue con el siguiente
                    }
                    // 6.2 Llama al servicio de correo para enviar la notificación
                    emailService.sendNotification(destinatario, subject, body);
                    //     Aquí se dispara realmente el envío. Si EmailService está bien configurado,
                    //     el correo sale hacia ese destinatario.
                }
            }
        }
    }

    @Override
    public ControlDTO editarControl(Long id, ControlDTO dto) {
        Control existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Control no encontrado"));

        // MapStruct actualiza sólo los campos del DTO
        mapper.updateFromDto(dto, existente);

        // Aseguro la back-reference en items
        existente.getItems().forEach(item -> item.setControl(existente));

        Control actualizado = repository.save(existente);
        return mapper.toDTO(actualizado);
    }

    @Override
    public ItemControlDTO cambiarEstadoItem(Long itemId) {
        ItemControl item = itemsControlRepository.findById(itemId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "ItemControl no encontrado"));
        // Invierte booleano (null se trata como false)
        Boolean actual = Boolean.TRUE.equals(item.getEstado());
        item.setEstado(!actual);
        ItemControl guardado = itemsControlRepository.save(item);
        return itemControlMapper.toDTO(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizacionSimpleDTO> obtenerOrganizacionesConItemsControl() {
        return repository.findSimpleOrganizacionesConItems();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemControlDTO> obtenerItemsPorOrganizacion(Long organizacionId) {
        return itemsControlRepository.findByOrganizacionId(organizacionId).stream()
                .map(itemControlMapper::toDTO)
                .toList();
    }

}
