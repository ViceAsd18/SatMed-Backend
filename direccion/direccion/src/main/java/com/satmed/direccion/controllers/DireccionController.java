package com.satmed.direccion.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.direccion.models.entities.Direccion;
import com.satmed.direccion.models.request.ActualizarDireccion;
import com.satmed.direccion.models.request.AgregarDireccion;
import com.satmed.direccion.services.DireccionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

@GetMapping("/listar") // Agregando el path para consistencia
    public ResponseEntity<List<Direccion>> obtenerTodas() {
        return ResponseEntity.ok(direccionService.listarTodas());
    }

    @PostMapping("/agregar") // Agregando el path para consistencia
    public ResponseEntity<Direccion> crear(@Valid @RequestBody AgregarDireccion request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(direccionService.crear(request));
    }

    // Para buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Direccion> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(direccionService.buscarPorId(id));
    }

    // Para actualizar
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Direccion> actualizar(@PathVariable Integer id, @Valid @RequestBody ActualizarDireccion request) {
        return ResponseEntity.ok(direccionService.actualizar(id, request));
    }

    // Para eliminar
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        direccionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}