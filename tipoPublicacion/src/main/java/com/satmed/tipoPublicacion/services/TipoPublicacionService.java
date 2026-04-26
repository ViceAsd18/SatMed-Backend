package com.satmed.tipoPublicacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satmed.tipoPublicacion.models.entities.TipoPublicacion;
import com.satmed.tipoPublicacion.repositories.TipoPublicacionRepository;

@Service
public class TipoPublicacionService {
    
    @Autowired
    private TipoPublicacionRepository tipoPublicacionRepository;

    public List<TipoPublicacion> obtenerTodosTiposPublicacion() {
        return tipoPublicacionRepository.findAll();
    }

    public List<TipoPublicacion> buscarPorNombre(String nombre) {
        return tipoPublicacionRepository.findByNombreTipoPublicacionContainingIgnoreCase(nombre);
    }
}
