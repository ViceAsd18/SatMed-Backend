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

    public List<Comuna> obtenerComunas () {
        return comunaRepository.findAll();
    }

    public Comuna obtenerComunaPorId (Integer idComuna) {

        Comuna comunaEncontrada = comunaRepository.findById(idComuna).orElse(null);

        if (comunaEncontrada == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La comuna con ID: " + idComuna + " no fue encontrada");
        }

        return comunaEncontrada;

    }

}
