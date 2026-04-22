package com.satmed.comuna.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.comuna.models.entities.Comuna;
import com.satmed.comuna.services.ComunaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("comunas")
public class ComunaController {
    
    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public List<Comuna> obtenerComunas() {
        return comunaService.obtenerComunas();
    }

    @GetMapping("/{id}")
    public Comuna obtenerComunaPorId(@PathVariable Integer id) {
        return comunaService.obtenerComunaPorId(id);
    }

    @GetMapping("/region/{idRegion}")
    public List<Comuna> obtenerComunasPorRegion(@PathVariable Integer idRegion) {
        return comunaService.obtenerComunasPorRegion(idRegion);
    }
    

}
