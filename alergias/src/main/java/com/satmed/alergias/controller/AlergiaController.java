package com.satmed.alergias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.alergias.models.entities.Alergia;
import com.satmed.alergias.services.AlergiaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("alergias")
public class AlergiaController {
    
    @Autowired
    private AlergiaService alergiaService;

    @GetMapping("")
    public List<Alergia> obtenerAlergias() {
        return alergiaService.obtenerAlergias();
    }

    @GetMapping("/{idAlergia}")
    public Alergia obtenerAlergiaPorId(@PathVariable Integer idAlergia) {
        return alergiaService.obtenerAlergiaPorId(idAlergia);
    }
    
    

}
