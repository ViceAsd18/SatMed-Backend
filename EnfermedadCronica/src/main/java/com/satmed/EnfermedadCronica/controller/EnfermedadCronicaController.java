package com.satmed.EnfermedadCronica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.satmed.EnfermedadCronica.models.entities.EnfermedadCronica;
import com.satmed.EnfermedadCronica.services.EnfermedadCronicaService;

@Repository
@RequestMapping("enfermedades-cronicas")
public class EnfermedadCronicaController {
    
    @Autowired
    private EnfermedadCronicaService enfermedadCronicaService;

    @GetMapping("")
    public List<EnfermedadCronica> obtenerEnfermedadesCronicas() {
        return enfermedadCronicaService.obtenerEnfermedadesCronicas();
    }

    @GetMapping("/{id}")
    public EnfermedadCronica obtenerEnfermedadCronicaPorId(Integer id) {
        return enfermedadCronicaService.obtenerEnfermedadCronicaPorId(id);
    }

}
