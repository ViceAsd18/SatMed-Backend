package com.satmed.atencion_medica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.atencion_medica.models.entities.Interconsulta;
import com.satmed.atencion_medica.models.request.ActualizarInterconsultaRequest;
import com.satmed.atencion_medica.models.request.RegistrarInterconsultaRequest;
import com.satmed.atencion_medica.servcies.InterconsultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/interconsultas")
@CrossOrigin
public class InterconsultaController {
    
    @Autowired
    private InterconsultaService interconsultaService;

    @PostMapping("")
    public ResponseEntity<?> crearInterconsulta(@Valid @RequestBody RegistrarInterconsultaRequest request) {
        try {
            Interconsulta nueva = interconsultaService.registrarInterconsulta(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("")
    public ResponseEntity<?> actualizarInterconsulta(@Valid @RequestBody ActualizarInterconsultaRequest request) {
        try {
            Interconsulta actualizada = interconsultaService.modificarInterconsulta(request);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interconsulta> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(interconsultaService.buscarPorId(id));
    }

    @GetMapping("/atencion/{idAtencion}")
    public ResponseEntity<List<Interconsulta>> listarPorAtencion(@PathVariable Long idAtencion) {
        return ResponseEntity.ok(interconsultaService.listarPorAtencion(idAtencion));
    }

    @GetMapping("/profesional/{idProfesional}")
    public ResponseEntity<List<Interconsulta>> listarPorProfesional(@PathVariable Long idProfesional) {
        return ResponseEntity.ok(interconsultaService.listarPorProfesional(idProfesional));
    }

}
