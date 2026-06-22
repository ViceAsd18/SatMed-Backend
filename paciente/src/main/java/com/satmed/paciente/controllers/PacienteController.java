package com.satmed.paciente.controllers;

import com.satmed.paciente.models.entities.Paciente;
import com.satmed.paciente.models.request.ActualizarPaciente;
import com.satmed.paciente.models.request.AgregarPaciente;
import com.satmed.paciente.services.PacienteService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping("/listar")
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{idPaciente}")
    public Paciente buscarPorId(@PathVariable Integer idPaciente) {
        return pacienteService.buscarPorId(idPaciente);
    }

    @PostMapping("/agregar")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente agregarPaciente(@Valid @RequestBody AgregarPaciente request) {
        return pacienteService.agregarPaciente(request);
    }

    @PutMapping("/actualizar/{idPaciente}")
    public Paciente actualizarPaciente(
            @PathVariable Integer idPaciente,
            @Valid @RequestBody ActualizarPaciente request) {
        return pacienteService.actualizarPaciente(idPaciente, request);
    }

    @DeleteMapping("/eliminar/{idPaciente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPaciente(@PathVariable Integer idPaciente) {
        pacienteService.eliminarPaciente(idPaciente);
    }
}
