package com.satmed.estadoTratamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. IMPORTAMOS LA ENTIDAD REAL
import com.satmed.estadoTratamiento.models.entities.EstadoTratamiento;
import com.satmed.estadoTratamiento.services.EstadoTratamientoService;

@RestController
@RequestMapping("/estado-tratamiento")
public class EstadoTratamientoController {
 
    @Autowired
    private EstadoTratamientoService estadoTratamientoService; 

    @GetMapping("")
    public List<EstadoTratamiento> obtenerEstadosTratamientos(){
        return estadoTratamientoService.obtenerEstadosTratamientos();
    }

    @GetMapping("/{id}")
    public EstadoTratamiento obtenerEstadoTratamiento(@PathVariable Integer id){
        return estadoTratamientoService.obtenerEstadoTratamientoPorId(id);
    }

}