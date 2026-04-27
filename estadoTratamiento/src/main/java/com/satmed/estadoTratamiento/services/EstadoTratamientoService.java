package com.satmed.estadoTratamiento.services;
import com.satmed.estadoTratamiento.repositories.EstadoTratamientoRepository;
import com.satmed.estadoTratamiento.models.entities.EstadoTratamiento;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EstadoTratamientoService {
    
    @Autowired
    private EstadoTratamientoRepository estadoTratamientoRepository;

    public List<EstadoTratamiento> obtenerEstadosTratamientos(){
        return estadoTratamientoRepository.findAll();
    }

    public EstadoTratamiento obtenerEstadoTratamientoPorId(Integer id){
    
        EstadoTratamiento estadoTratamiento = estadoTratamientoRepository.findById(id).orElse(null);

        if (estadoTratamiento == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Estado con id " + id + " no encontrado");
        }
        return estadoTratamiento;   
    }



}
