package com.satmed.horarioProfesional.services;


import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satmed.horarioProfesional.models.entities.DiaSemana;
import com.satmed.horarioProfesional.models.entities.HorarioProfesional;
import com.satmed.horarioProfesional.models.request.ActualizarHorarioRequest;
import com.satmed.horarioProfesional.models.request.AgregarHorarioRequest;
import com.satmed.horarioProfesional.repositories.DiaSemanaRepository;
import com.satmed.horarioProfesional.repositories.HorarioProfesionalRepository;

@Service
public class HorarioProfesionalService {

    @Autowired
    private HorarioProfesionalRepository horarioProfesionalRepository;

    @Autowired
    private DiaSemanaRepository diaSemanaRepository;

    public List<HorarioProfesional> obtenerTodosLosHorarios() {
        return horarioProfesionalRepository.findAll();
    }

    public HorarioProfesional obtenerHorarioPorId(Long id) {
        return horarioProfesionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: No se encontró el horario profesional con ID: " + id));
    }

    public List<HorarioProfesional> obtenerHorariosPorProfesional(Long idProfesional) {
        return horarioProfesionalRepository.findByIdProfesional(idProfesional);
    }

    public HorarioProfesional registrarHorarioProfesional(AgregarHorarioRequest request) {
        // Validar que la hora inicio sea menor que la de fin
        validarConsistenciaHoraria(request.getHoraInicio(), request.getHoraFin());

        // Validar que el día de la semana exista
        DiaSemana dia = diaSemanaRepository.findById(request.getIdDiaSemana())
                .orElseThrow(() -> new RuntimeException("Error: El día de la semana con ID " + request.getIdDiaSemana() + " no existe."));

        // Mapear datos a la entidad
        HorarioProfesional nuevoHorario = new HorarioProfesional();
        nuevoHorario.setHoraInicio(request.getHoraInicio());
        nuevoHorario.setHoraFin(request.getHoraFin());
        nuevoHorario.setIdProfesional(request.getIdProfesional());
        nuevoHorario.setDiaSemana(dia);

        return horarioProfesionalRepository.save(nuevoHorario);
    }

    public HorarioProfesional modificarHorarioProfesional(ActualizarHorarioRequest request) {
        // Verificar que el horario exista
        HorarioProfesional horarioExistente = obtenerHorarioPorId(request.getIdHorarioProfesional());

        // Validar horas
        validarConsistenciaHoraria(request.getHoraInicio(), request.getHoraFin());

        // Validar día
        DiaSemana dia = diaSemanaRepository.findById(request.getIdDiaSemana())
                .orElseThrow(() -> new RuntimeException("Error: El día de la semana con ID " + request.getIdDiaSemana() + " no existe."));

        // Actualizar datos
        horarioExistente.setHoraInicio(request.getHoraInicio());
        horarioExistente.setHoraFin(request.getHoraFin());
        horarioExistente.setDiaSemana(dia);

        return horarioProfesionalRepository.save(horarioExistente);
    }

    public void darDeBajaHorarioProfesional(Long id) {
        HorarioProfesional horario = obtenerHorarioPorId(id);
        horarioProfesionalRepository.delete(horario);
    }

    //METODO PRIVADO DE VALIDACIÓN
    private void validarConsistenciaHoraria(String horaInicioStr, String horaFinStr) {
        try {
            LocalTime inicio = LocalTime.parse(horaInicioStr);
            LocalTime fin = LocalTime.parse(horaFinStr);

            if (inicio.isAfter(fin) || inicio.equals(fin)) {
                throw new RuntimeException("Error de negocio: La hora de inicio (" + horaInicioStr + ") debe ser menor que la de fin (" + horaFinStr + ").");
            }
        } catch (Exception e) {
            if (e instanceof RuntimeException) throw e;
            throw new RuntimeException("Error de formato: Las horas deben venir en formato HH:mm (Ej: '08:30').");
        }
    }

    


}
