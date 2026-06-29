package com.satmed.paciente.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.satmed.paciente.models.dto.PacienteResponseDto;
import com.satmed.paciente.models.entities.Paciente;
import com.satmed.paciente.services.PacienteService;

@RestController
@RequestMapping("/api/pacientes") 
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/listar")
    public List<PacienteResponseDto> obtenerPacientes() {
        return pacienteService.obtenerPacientes();
    }

    @GetMapping("/buscar/{id}")
    public PacienteResponseDto obtenerPacientePorId(@PathVariable Integer id) {
        return pacienteService.obtenerPacientePorId(id);
    }

    @PostMapping("/agregar")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.crearPaciente(paciente);
    }

    @PutMapping("/actualizar/{id}")
    public Paciente actualizarPaciente(@PathVariable Integer id, @RequestBody Paciente paciente) {
        return pacienteService.actualizarPaciente(id, paciente);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Integer id) {
        return pacienteService.eliminarPaciente(id);
    }
}   