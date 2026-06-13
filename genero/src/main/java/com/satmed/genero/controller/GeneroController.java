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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/generos")
@Tag(name = "Géneros", description = "Endpoints para la gestión de géneros del sistema SAT-MED")
public class GeneroController {

    @Autowired
    private GeneroServices generoService;


    @Operation(summary = "Listar todos los géneros")
    @GetMapping("")
    public List<Genero> listar() {
        return generoService.obtenerTodosGenero();
    }


    @Operation(summary = "Obtener un género por su ID")
    @GetMapping("/{id}")
    public Genero buscarPorId(@PathVariable Integer id) {
        return generoService.obtenerGeneroPorId(id);
    }


    @Operation(summary = "Eliminar un género por su ID")
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        return generoService.eliminarGenero(id);
    }
}

