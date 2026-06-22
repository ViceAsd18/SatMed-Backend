package com.satmed.atencion_medica.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.satmed.atencion_medica.models.entities.AtencionMedica;
import com.satmed.atencion_medica.models.entities.BitacoraAtencion;
import com.satmed.atencion_medica.models.request.ActualizarAtencionRequest;
import com.satmed.atencion_medica.models.request.RegistrarAtencionRequest;
import com.satmed.atencion_medica.models.request.RegistrarBitacoraRequest;
import com.satmed.atencion_medica.servcies.AtencionMedicaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/atenciones-medicas")
@CrossOrigin
public class AtencionMedicaController {

    @Autowired
    private AtencionMedicaService atencionService;

    @PostMapping("")
    public ResponseEntity<?> registrarAtencion(@Valid @RequestBody RegistrarAtencionRequest request) {
        try {
            AtencionMedica nueva = atencionService.registrarNuevaAtencionMedica(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("")
    public ResponseEntity<?> actualizarAtencion(@Valid @RequestBody ActualizarAtencionRequest request) {
        try {
            AtencionMedica actualizada = atencionService.modificarAtencionMedica(request);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtencionMedica> buscarAtencionPorId(@PathVariable Long id) {
        return ResponseEntity.ok(atencionService.obtenerDetalleDeAtencionPorId(id));
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<AtencionMedica>> buscarHistorialPorPaciente(@PathVariable Long idPaciente) {
        return ResponseEntity.ok(atencionService.obtenerHistorialClinicoPorPaciente(idPaciente));
    }

    @PostMapping("/bitacora")
    public ResponseEntity<?> agregarEventoBitacora(@Valid @RequestBody RegistrarBitacoraRequest request) {
        try {
            BitacoraAtencion nuevaBitacora = atencionService.registrarEventoEnBitacora(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaBitacora);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/bitacora/atencion/{idAtencion}")
    public ResponseEntity<List<BitacoraAtencion>> listarBitacoraDeAtencion(@PathVariable Long idAtencion) {
        return ResponseEntity.ok(atencionService.obtenerBitacoraDeAtencion(idAtencion));
    }
}
