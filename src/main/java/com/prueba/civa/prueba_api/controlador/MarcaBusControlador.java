package com.prueba.civa.prueba_api.controlador;

import com.prueba.civa.prueba_api.dto.MarcaBusDTO;
import com.prueba.civa.prueba_api.servicio.MarcaBusServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/marcaBus")
public class MarcaBusControlador {
    @Autowired
    private MarcaBusServicio marcaBusServicio;

    @PostMapping
    public ResponseEntity<MarcaBusDTO> guardarMarcaBus(@RequestBody MarcaBusDTO marcaBusDTO) {
        return new ResponseEntity<>(marcaBusServicio.crearMarcaBus(marcaBusDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<MarcaBusDTO> listarMarcasBuses() {
        return marcaBusServicio.obtenerTodasLasMarcas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaBusDTO> obtenerMarcaBus(@PathVariable Long id) {
        return ResponseEntity.ok(marcaBusServicio.obtenerMarcaBus(id));
    }
}
