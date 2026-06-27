package com.satmed.cita.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.cita.models.entities.Cita;
import com.satmed.cita.models.request.ActualizarCita;
import com.satmed.cita.models.request.AgregarCita;
import com.satmed.cita.services.CitaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cita>> listar() {
        return ResponseEntity.ok(citaService.listar());
    }

    @GetMapping("/{idCita}")
    public ResponseEntity<Cita> obtenerPorId(@PathVariable Integer idCita) {
        return citaService.buscarPorId(idCita)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/agregar")
    public ResponseEntity<Cita> agregar(@Valid @RequestBody AgregarCita request) {
        Cita citaCreada = citaService.agregar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(citaCreada);
    }

    @PutMapping("/actualizar/{idCita}")
    public ResponseEntity<Cita> actualizar(@PathVariable Integer idCita, @Valid @RequestBody ActualizarCita request) {
        return citaService.actualizar(idCita, request)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{idCita}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idCita) {
        boolean eliminada = citaService.eliminar(idCita);
        if (!eliminada) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}