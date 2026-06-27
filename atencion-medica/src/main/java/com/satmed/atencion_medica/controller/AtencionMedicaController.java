package com.satmed.atencion_medica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.atencion_medica.models.entities.AtencionMedica;
import com.satmed.atencion_medica.services.AtencionMedicaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("atenciones-medicas")
@Tag(name = "Atención Médica", description = "Endpoints para la gestión de atenciones médicas en SAT-MED Coquimbo")
public class AtencionMedicaController {
    
    @Autowired
    private AtencionMedicaService atencionMedicaService;

    @GetMapping("")
    @Operation(summary = "Obtener todas las atenciones médicas", description = "Recupera una lista completa con los registros de atenciones médicas.")
    public List<AtencionMedica> obtenerAtencionMedica() {
        return atencionMedicaService.obtenerAtencionMedica();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener atención médica por ID", description = "Busca y retorna los detalles de una atención médica específica mediante su ID único.")
    public AtencionMedica obtenerAtencionMedicaPorId(@PathVariable Integer id) {
        return atencionMedicaService.obtenerAtencionMedicaPorId(id);
    }
}