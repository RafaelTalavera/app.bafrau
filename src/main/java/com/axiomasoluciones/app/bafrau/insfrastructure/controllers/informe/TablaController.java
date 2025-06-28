package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CeldaDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.TablaDTO;
import com.axiomasoluciones.app.bafrau.application.serviceImplement.informe.CeldaService;
import com.axiomasoluciones.app.bafrau.application.serviceImplement.informe.TablaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tablas")
@CrossOrigin(origins = "*")

public class TablaController {
    private final TablaService tablaService;
    private final CeldaService celdaService;

    public TablaController(TablaService tablaService, CeldaService celdaService) {
        this.tablaService = tablaService;
        this.celdaService = celdaService;
    }

    @PostMapping
    public ResponseEntity<TablaDTO> crear(
            @RequestParam Integer filas,
            @RequestParam Integer columnas,
            @RequestParam Long seccionId,
            @RequestParam String nombre) {
        TablaDTO dto = tablaService.crearTabla(filas, columnas, seccionId, nombre);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/seccion/{id}")
    public List<TablaDTO> porSeccion(@PathVariable Long id) {
        return tablaService.listarPorSeccion(id);
    }

    @PutMapping("/editar-masivo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> actualizarContenidoMasivo(@RequestBody List<CeldaDTO> celdas) {
        celdaService.actualizarVarias(celdas);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tablaService.eliminarTabla(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }
}
