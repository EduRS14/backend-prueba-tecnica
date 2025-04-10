package com.prueba.civa.prueba_api.servicio;

import com.prueba.civa.prueba_api.dto.BusDTO;
import com.prueba.civa.prueba_api.dto.MarcaBusDTO;

import java.util.List;

public interface MarcaBusServicio {

    public MarcaBusDTO crearMarcaBus(MarcaBusDTO marcaBusDTO);

    public List<MarcaBusDTO> obtenerTodasLasMarcas();

    public MarcaBusDTO obtenerMarcaBus(Long id);
}
