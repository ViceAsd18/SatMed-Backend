package com.satmed.reunion_clinica.controller;

import com.satmed.reunion_clinica.models.entities.BitacoraReunion;
import com.satmed.reunion_clinica.models.entities.ReunionClinica;
import com.satmed.reunion_clinica.models.request.BitacoraRequest;
import com.satmed.reunion_clinica.models.request.ReunionRequest;
import com.satmed.reunion_clinica.services.ReunionClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reuniones-clinicas")
@CrossOrigin(origins = "*") // Para que no te hdee el Angular con el CORS
public class ReunionClinicaController {

    @Autowired
    private ReunionClinicaService reunionService;

    @PostMapping
    public ResponseEntity<ReunionClinica> crearReunion(@RequestBody ReunionRequest request) {
        ReunionClinica nuevaReunion = reunionService.crearReunion(request);
        return new ResponseEntity<>(nuevaReunion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReunionClinica>> listarReuniones() {
        return ResponseEntity.ok(reunionService.listarReuniones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReunionClinica> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(reunionService.buscarReunionPorId(id));
    }

    @PostMapping("/bitacoras")
    public ResponseEntity<BitacoraReunion> crearBitacora(@RequestBody BitacoraRequest request) {
        BitacoraReunion nuevaBitacora = reunionService.crearBitacora(request);
        return new ResponseEntity<>(nuevaBitacora, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/bitacoras")
    public ResponseEntity<List<BitacoraReunion>> listarBitacorasPorReunion(@PathVariable Long id) {
        return ResponseEntity.ok(reunionService.listarBitacorasPorReunion(id));
    }
}