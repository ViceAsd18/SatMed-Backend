package com.satmed.horarioProfesional.controllers;

import com.satmed.horarioProfesional.models.entities.HorarioProfesional;
import com.satmed.horarioProfesional.models.request.ActualizarHorarioRequest;
import com.satmed.horarioProfesional.models.request.AgregarHorarioRequest;
import com.satmed.horarioProfesional.services.HorarioProfesionalService;
import jakarta.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/horarios-profesional")
@CrossOrigin
public class HorarioProfesionalController {

    @Autowired
    private HorarioProfesionalService horarioService;

    @GetMapping("")
    public ResponseEntity<List<HorarioProfesional>> listarTodosLosHorarios() {
        return ResponseEntity.ok(horarioService.obtenerTodosLosHorarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioProfesional> buscarHorarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(horarioService.obtenerHorarioPorId(id));
    }

    @GetMapping("/profesional/{idProfesional}")
    public ResponseEntity<List<HorarioProfesional>> buscarHorariosPorProfesional(@PathVariable Long idProfesional) {
        return ResponseEntity.ok(horarioService.obtenerHorariosPorProfesional(idProfesional));
    }

    @PostMapping("")
    public ResponseEntity<?> agregarHorarioProfesional(@Valid @RequestBody AgregarHorarioRequest request) {
        try {
            HorarioProfesional nuevo = horarioService.registrarHorarioProfesional(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("")
    public ResponseEntity<?> actualizarHorarioProfesional(@Valid @RequestBody ActualizarHorarioRequest request) {
        try {
            HorarioProfesional actualizado = horarioService.modificarHorarioProfesional(request);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarHorarioProfesional(@PathVariable Long id) {
        try {
            horarioService.darDeBajaHorarioProfesional(id);
            return ResponseEntity.ok("Horario eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
