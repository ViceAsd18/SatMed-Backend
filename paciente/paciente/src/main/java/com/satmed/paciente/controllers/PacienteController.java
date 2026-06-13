package com.satmed.paciente.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.paciente.models.entities.Paciente;
import com.satmed.paciente.models.request.ActualizarPaciente;
import com.satmed.paciente.models.request.AgregarPaciente;
import com.satmed.paciente.services.PacienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pacientes")
@Tag(name = "Pacientes", description = "Endpoints para la gestión de pacientes del sistema SAT-MED")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @Operation(summary = "Listar todos los pacientes")
    @GetMapping("/listar")
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @Operation(summary = "Obtener un paciente por su ID")
    @GetMapping("/{idPaciente}")
    public Paciente buscarPorId(@PathVariable Integer idPaciente) {
        return pacienteService.buscarPorId(idPaciente);
    }

    @Operation(summary = "Agregar un nuevo paciente")
    @PostMapping("/agregar")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente agregarPaciente(@Valid @RequestBody AgregarPaciente request) {
        return pacienteService.agregarPaciente(request);
    }

    @Operation(summary = "Actualizar un paciente existente")
    @PutMapping("/actualizar/{idPaciente}")
    public Paciente actualizarPaciente(
            @PathVariable Integer idPaciente,
            @Valid @RequestBody ActualizarPaciente request) {
        return pacienteService.actualizarPaciente(idPaciente, request);
    }

    @Operation(summary = "Eliminar un paciente por su ID")
    @DeleteMapping("/eliminar/{idPaciente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPaciente(@PathVariable Integer idPaciente) {
        pacienteService.eliminarPaciente(idPaciente);
    }
}


