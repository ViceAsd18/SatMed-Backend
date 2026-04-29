package com.satmed.direccion.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.satmed.direccion.models.entities.Direccion;
import com.satmed.direccion.models.request.ActualizarDireccion;
import com.satmed.direccion.models.request.AgregarDireccion;
import com.satmed.direccion.services.DireccionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping
    public List<Direccion> obtenerTodas() {
        return direccionService.listarTodas();
    }

    @GetMapping("/{id}")
    public Direccion obtenerPorId(@PathVariable Integer id) {
        return direccionService.buscarPorId(id);
    }

    @PostMapping
    public Direccion crear(@Valid @RequestBody AgregarDireccion request) {
        return direccionService.crearDireccion(request);
    }

    @PutMapping("/{id}")
    public Direccion actualizar(@PathVariable Integer id, @Valid @RequestBody ActualizarDireccion request) {
        return direccionService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        return direccionService.eliminar(id);
    }
}