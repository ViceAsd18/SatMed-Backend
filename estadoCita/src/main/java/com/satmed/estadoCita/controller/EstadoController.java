package com.satmed.estadoCita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.estadoCita.models.entities.EstadoCita;
import com.satmed.estadoCita.services.EstadoCitaService;

@RestController
@RequestMapping("estados-cita")
public class EstadoController {
    
    @Autowired
    private EstadoCitaService estadoCitaService;
    
    @GetMapping("")
    public List<EstadoCita> obtenerTodosEstadosCita() {
        return estadoCitaService.obtenerTodosEstadosCita();
    }

    @GetMapping("/buscar/{nombre}")
    public List<EstadoCita> buscarPorNombre(@PathVariable String nombre) {
        return estadoCitaService.buscarPorNombre(nombre);
    }

}
