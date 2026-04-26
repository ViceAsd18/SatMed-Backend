package com.satmed.tipoPublicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.tipoPublicacion.models.entities.TipoPublicacion;
import com.satmed.tipoPublicacion.services.TipoPublicacionService;

@RestController
@RequestMapping("tipo-publicacion")
public class TipoPublicacionController {
    
    @Autowired
    private TipoPublicacionService tipoPublicacionService;
    
    @GetMapping("")
    public List<TipoPublicacion> obtenerTodosTiposPublicacion() {
        return tipoPublicacionService.obtenerTodosTiposPublicacion();
    }

    @GetMapping("/buscar/{nombre}")
    public List<TipoPublicacion> buscarPorNombre(@PathVariable String nombre) {
        return tipoPublicacionService.buscarPorNombre(nombre);
    }


}
