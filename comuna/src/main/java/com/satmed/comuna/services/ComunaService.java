package com.satmed.comuna.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.comuna.repositories.ComunaRepository;
import com.satmed.comuna.models.entities.Comuna;


@Service
public class ComunaService {
    
    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> obtenerComunas() {
        return comunaRepository.findAll();
    }

    public Comuna obtenerComunaPorId(Integer id) {
        Comuna comunaEncontrada = comunaRepository.findById(id).orElse(null);

        if (comunaEncontrada == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comuna con ID: " + id + " no encontrada");
        }

        return comunaEncontrada;
    }

    public List<Comuna> obtenerComunasPorRegion(Integer idRegion) {
        return comunaRepository.findByIdRegion(idRegion);
    }

}
