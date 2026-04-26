package com.satmed.cita.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.satmed.cita.models.entities.Cita;
import com.satmed.cita.models.request.ActualizarCita;
import com.satmed.cita.models.request.AgregarCita;
import com.satmed.cita.repositories.CitaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;

    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    public Optional<Cita> buscarPorId(Integer idCita) {
        return citaRepository.findById(idCita);
    }

    @Transactional
    public Cita agregar(AgregarCita request) {
        // Usamos el Builder que agregamos a la Entity Cita.java
        Cita nuevaCita = Cita.builder()
                .fechaHora(request.getFechaHora())
                .motivoCita(request.getMotivoCita())
                .estadoCitaIdEstadoCita(request.getEstadoCitaIdEstadoCita())
                .profesionalIdProfesional(request.getProfesionalIdProfesional())
                .pacienteIdPaciente(request.getPacienteIdPaciente())
                .build();

        return citaRepository.save(nuevaCita);
    }

    @Transactional
    public Optional<Cita> actualizar(Integer idCita, ActualizarCita request) {
        return citaRepository.findById(idCita).map(cita -> {
            // Estos setters funcionan porque pusimos @Data o @Setter en Cita.java
            cita.setFechaHora(request.getFechaHora());
            cita.setMotivoCita(request.getMotivoCita());
            cita.setEstadoCitaIdEstadoCita(request.getEstadoCitaIdEstadoCita());
            cita.setProfesionalIdProfesional(request.getProfesionalIdProfesional());
            cita.setPacienteIdPaciente(request.getPacienteIdPaciente());
            return citaRepository.save(cita);
        });
    }

    @Transactional
    public boolean eliminar(Integer idCita) {
        if (!citaRepository.existsById(idCita)) {
            return false;
        }
        citaRepository.deleteById(idCita);
        return true;
    }
}
