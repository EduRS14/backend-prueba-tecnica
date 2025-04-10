package com.prueba.civa.prueba_api.servicio;

import com.prueba.civa.prueba_api.dto.BusDTO;
import com.prueba.civa.prueba_api.dto.MarcaBusDTO;
import com.prueba.civa.prueba_api.entidades.Bus;
import com.prueba.civa.prueba_api.entidades.MarcaBus;
import com.prueba.civa.prueba_api.excepciones.ResourceNotFoundException;
import com.prueba.civa.prueba_api.repositorio.BusRepositorio;
import com.prueba.civa.prueba_api.repositorio.MarcaBusRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusServicioImpl implements BusServicio {

    @Autowired
    private BusRepositorio busRepositorio;

    @Autowired
    private MarcaBusRepositorio marcaBusRepositorio;

    @Override
    public BusDTO crearBus(BusDTO busDTO) {
        // Convertimos de DTO a entidad
        Bus bus = mapearDTOBus(busDTO);

        MarcaBus marcaBus = marcaBusRepositorio.findById(busDTO.getMarca().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Marca de bus", "id", busDTO.getMarca().getId()));

        bus.setMarca(marcaBus);

        Bus nuevoBus = busRepositorio.save(bus);

        return mapearBusDTO(nuevoBus);
    }

    public List<BusDTO> obtenerTodosLosBuses(){
        List<Bus> buses = busRepositorio.findAll();
        return buses.stream().map(bus -> mapearBusDTO(bus)).collect(Collectors.toList());
    }

    public BusDTO obtenerBus(Long id){
        Bus bus = busRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", id));
        return mapearBusDTO(bus);
    }

    private BusDTO mapearBusDTO(Bus bus){
        BusDTO busDTO = new BusDTO();

        busDTO.setId(bus.getId());
        busDTO.setNumeroBus(String.valueOf(bus.getNumeroBus()));
        busDTO.setPlaca(bus.getPlaca());
        busDTO.setFechaCreacion(bus.getFechaCreacion().toString());
        busDTO.setCaracteristicas(bus.getCaracteristicas());
        busDTO.setActivo(bus.isActivo());

        MarcaBus marcaBus = bus.getMarca();
        if (marcaBus != null) {
            MarcaBusDTO marcaBusDTO = new MarcaBusDTO();
            marcaBusDTO.setId(marcaBus.getId());
            marcaBusDTO.setNombre(marcaBus.getNombre());
            marcaBusDTO.setDescripcion(marcaBus.getDescripcion());
            busDTO.setMarca(marcaBusDTO);
        }

        return busDTO;
    }

    private Bus mapearDTOBus(BusDTO busDTO) {
        Bus bus = new Bus();

        try {
            bus.setNumeroBus(Integer.parseInt(busDTO.getNumeroBus()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El número de bus debe ser un número válido");
        }

        bus.setPlaca(busDTO.getPlaca());

        bus.setCaracteristicas(busDTO.getCaracteristicas());

        bus.setActivo(busDTO.isActivo());

        return bus;
    }
}