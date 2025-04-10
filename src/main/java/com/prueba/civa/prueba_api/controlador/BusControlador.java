package com.prueba.civa.prueba_api.controlador;

import com.prueba.civa.prueba_api.dto.BusDTO;
import com.prueba.civa.prueba_api.servicio.BusServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/bus")
public class BusControlador {

    @Autowired
    private BusServicio busServicio;

    @PostMapping
    public ResponseEntity<BusDTO> guardarBus(@RequestBody BusDTO busDTO) {
        return new ResponseEntity<>(busServicio.crearBus(busDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<BusDTO> listarBuses(){
        return  busServicio.obtenerTodosLosBuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDTO> obtenerBus(@PathVariable Long id){
        return ResponseEntity.ok(busServicio.obtenerBus(id));
    }

}
