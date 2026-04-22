package com.satmed.genero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.genero.models.entities.Genero;
import com.satmed.genero.services.GeneroServices;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroServices generoService;


    @GetMapping("/listar")
    public List<Genero> listar() {
        return generoService.obtenerTodosGenero();
    }


    @GetMapping("/buscar/{id}")
    public Genero buscarPorId(@PathVariable Integer id) {
        return generoService.obtenerGeneroPorId(id);
    }


    // DELETE: Eliminar género
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        return generoService.eliminarGenero(id);
    }
}

