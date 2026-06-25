package com.satmed.alergias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.alergias.models.entities.Alergia;
import com.satmed.alergias.services.AlergiaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("alergias")
@Tag(name = "Alergias", description = "Endpoints para la gestión y consulta de allergies en SAT-MED")
public class AlergiaController {
    
    @Autowired
    private AlergiaService alergiaService;

    @GetMapping("")
    @Operation(summary = "Listar todas las alergias", description = "Recupera una lista completa de todas las alergias registradas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de alergias obtenida exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<Alergia> obtenerAlergias() {
        return alergiaService.obtenerAlergias();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener alergia por ID", description = "Busca una alergia específica mediante su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Alergia encontrada exitosamente"),
        @ApiResponse(responseCode = "404", description = "No se encontró ninguna alergia con el ID proporcionado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public Alergia obtenerAlergiaPorId(@PathVariable Integer id) {
        return alergiaService.obtenerAlergiaPorId(id);
    }
}