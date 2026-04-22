package com.satmed.genero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.genero.models.entities.Genero;
import com.satmed.genero.repositories.GeneroRepository;

@Service
public class GeneroServices {
    
    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> obtenerTodosGenero() {
        return generoRepository.findAll();
    } 

    public Genero obtenerGeneroPorId(Integer idGenero) {
        // El .findById espera el mismo tipo que definiste en la Entity
        Genero generoEncontrado = generoRepository.findById(idGenero).orElse(null);
    
        if (generoEncontrado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Género con id: " + idGenero + " no fue encontrado");
        }

        return generoEncontrado;
    }

    public String eliminarGenero(Integer idGenero) {
        Genero generoExistente = generoRepository.findById(idGenero).orElse(null);

        if (generoExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Género con id: " + idGenero + " no fue encontrado");
        }

        generoRepository.deleteById(idGenero);
        return "Género eliminado correctamente";
    }
    
}