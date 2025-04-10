package com.prueba.civa.prueba_api.servicio;

import com.prueba.civa.prueba_api.dto.BusDTO;

import java.util.List;

public interface BusServicio {

    public BusDTO crearBus(BusDTO busDTO);

    public List<BusDTO> obtenerTodosLosBuses();

    public BusDTO obtenerBus(Long id);
}
