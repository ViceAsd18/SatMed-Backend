package com.satmed.EnfermedadCronica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.EnfermedadCronica.models.entities.EnfermedadCronica;
import com.satmed.EnfermedadCronica.services.EnfermedadCronicaService;

@RestController
@RequestMapping("enfermedades-cronicas")
public class EnfermedadCronicaController {
    
    @Autowired
    private EnfermedadCronicaService enfermedadCronicaService;

    @GetMapping("")
    public List<EnfermedadCronica> obtenerEnfermedadesCronicas() {
        return enfermedadCronicaService.obtenerEnfermedadesCronicas();
    }

    @GetMapping("/{id}")
    public EnfermedadCronica obtenerEnfermedadCronicaPorId(@PathVariable Integer id) {
        return enfermedadCronicaService.obtenerEnfermedadCronicaPorId(id);
    }

}
