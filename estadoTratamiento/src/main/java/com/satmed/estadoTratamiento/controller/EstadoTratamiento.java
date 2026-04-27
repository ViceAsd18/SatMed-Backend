package com.satmed.estadoTratamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class EstadoTratamiento {
 
    @Autowired
    private EstadoTratamiento estadoTratamiento;

    @GetMapping("")
    public List<EstadoTratamiento> obtenerEstadosTratamientos(){
        return estadoTratamiento.obtenerEstadosTratamientos();
    }

    @GetMapping("/{id}")
    public EstadoTratamiento obtenerEstadoTratamiento(@PathVariable Integer id){
        return estadoTratamiento.obtenerEstadoTratamiento(id);
    }

}
