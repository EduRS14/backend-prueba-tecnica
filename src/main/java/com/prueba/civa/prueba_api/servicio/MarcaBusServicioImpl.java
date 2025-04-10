package com.prueba.civa.prueba_api.servicio;

import com.prueba.civa.prueba_api.dto.MarcaBusDTO;
import com.prueba.civa.prueba_api.entidades.MarcaBus;
import com.prueba.civa.prueba_api.excepciones.ResourceNotFoundException;
import com.prueba.civa.prueba_api.repositorio.MarcaBusRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaBusServicioImpl implements MarcaBusServicio {

    @Autowired
    private MarcaBusRepositorio marcaBusRepositorio;

    @Override
    public MarcaBusDTO crearMarcaBus(MarcaBusDTO marcaBusDTO) {
        MarcaBus marcaBus = mapearDTOMarcaBus(marcaBusDTO);
        MarcaBus nuevoMarcaBus = marcaBusRepositorio.save(marcaBus);

        return mapearMarcaBusDTO(nuevoMarcaBus);
    }

    public List<MarcaBusDTO> obtenerTodasLasMarcas(){
        List<MarcaBus> marcasBuses = marcaBusRepositorio.findAll();
        return marcasBuses.stream().map(marcaBus -> mapearMarcaBusDTO(marcaBus)).collect(Collectors.toList());
    }

    public MarcaBusDTO obtenerMarcaBus(Long id){
        MarcaBus marcaBus = marcaBusRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marca de bus", "id", id));
        return mapearMarcaBusDTO(marcaBus);
    }

    private MarcaBusDTO mapearMarcaBusDTO(MarcaBus marcaBus){
        MarcaBusDTO marcaBusDTO = new MarcaBusDTO();

        marcaBusDTO.setId(marcaBus.getId());
        marcaBusDTO.setNombre(marcaBus.getNombre());
        marcaBusDTO.setDescripcion(marcaBus.getDescripcion());

        return marcaBusDTO;
    }

    private MarcaBus mapearDTOMarcaBus(MarcaBusDTO marcaBusDTO) {
        MarcaBus marcaBus = new MarcaBus();

        marcaBus.setNombre(marcaBusDTO.getNombre());
        marcaBus.setDescripcion(marcaBusDTO.getDescripcion());

        return marcaBus;
    }

}
