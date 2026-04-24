package com.satmed.EnfermedadCronica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satmed.EnfermedadCronica.models.entities.EnfermedadCronica;
import com.satmed.EnfermedadCronica.repositories.EnfermedadCronicaRepository;

@Service
public class EnfermedadCronicaService {
    
    @Autowired
    private EnfermedadCronicaRepository enfermedadCronicaRepository;

    public List<EnfermedadCronica> obtenerEnfermedadesCronicas() {
        return enfermedadCronicaRepository.findAll();
    }

    public EnfermedadCronica obtenerEnfermedadCronicaPorId(Integer id) {
    
        EnfermedadCronica enfermedadCronicaEncontrada = enfermedadCronicaRepository.findById(id).orElse(null);

        if (enfermedadCronicaEncontrada == null) {
            throw new RuntimeException("Enfermedad crónica con el ID: " + id + " no encontrada");
        }

        return enfermedadCronicaEncontrada;
    }




}
