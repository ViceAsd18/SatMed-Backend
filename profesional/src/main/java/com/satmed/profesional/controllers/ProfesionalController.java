package com.satmed.profesional.controllers;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.satmed.profesional.models.dto.ProfesionalResponseDto;
import com.satmed.profesional.models.entities.Profesional;
import com.satmed.profesional.models.request.ActualizarProfesional;
import com.satmed.profesional.models.request.AgregarProfesional;
import com.satmed.profesional.services.ProfesionalService;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {

    @Autowired
    private ProfesionalService profesionalService;

    @GetMapping
    public ResponseEntity<List<ProfesionalResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(profesionalService.obtenerTodosLosProfesionales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesionalResponseDto> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(profesionalService.obtenerProfesionalPorId(id));
    }

    @PostMapping
    public ResponseEntity<Profesional> agregar(@Valid @RequestBody AgregarProfesional request) {
        return new ResponseEntity<>(profesionalService.agregarProfesional(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Profesional> actualizar(@Valid @RequestBody ActualizarProfesional request) {
        return ResponseEntity.ok(profesionalService.actualizarProfesional(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        return ResponseEntity.ok(profesionalService.eliminarProfesional(id));
    }
}