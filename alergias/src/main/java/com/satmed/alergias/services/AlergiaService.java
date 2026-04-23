package com.satmed.alergias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.alergias.models.entities.Alergia;
import com.satmed.alergias.repositories.AlergiaRepository;

@Service
public class AlergiaService {
    
    @Autowired
    private AlergiaRepository alergiaRepository;

    public List<Alergia> obtenerAlergias(){
        return alergiaRepository.findAll();
    } 

    public Alergia obtenerAlergiaPorId(Integer idAlergia) {
        
        Alergia alergiaExistente = alergiaRepository.findById(idAlergia).orElse(null);

        if (alergiaExistente == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La alergia con ID: " + idAlergia + " no fue encontrada");
        }

        return alergiaExistente;

    }

}
