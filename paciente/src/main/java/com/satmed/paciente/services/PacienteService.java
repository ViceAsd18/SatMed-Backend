package com.satmed.paciente.services;

import com.satmed.paciente.models.entities.Paciente;
import com.satmed.paciente.models.request.ActualizarPaciente;
import com.satmed.paciente.models.request.AgregarPaciente;
import com.satmed.paciente.repositories.PacienteRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId(Integer idPaciente) {
        return pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Paciente no encontrado con id: " + idPaciente));
    }

    public Paciente agregarPaciente(AgregarPaciente request) {
        Paciente paciente = Paciente.builder()
                .idPaciente(request.getIdPaciente())
                .idEstadoPaciente(request.getIdEstadoPaciente())
                .build();
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizarPaciente(Integer idPaciente, ActualizarPaciente request) {
        Paciente paciente = buscarPorId(idPaciente);
        paciente.setIdEstadoPaciente(request.getIdEstadoPaciente());
        return pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Integer idPaciente) {
        Paciente paciente = buscarPorId(idPaciente);
        pacienteRepository.delete(paciente);
    }
}
