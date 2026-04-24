package com.satmed.horarioProfesional.services;

import com.satmed.horarioProfesional.models.entities.HorarioProfesional;
import com.satmed.horarioProfesional.models.request.ActualizarHorarioProfesional;
import com.satmed.horarioProfesional.models.request.AgregarHorarioProfesional;
import com.satmed.horarioProfesional.repositories.HorarioProfesionalRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HorarioProfesionalService {

    private final HorarioProfesionalRepository horarioProfesionalRepository;

    public HorarioProfesionalService(HorarioProfesionalRepository horarioProfesionalRepository) {
        this.horarioProfesionalRepository = horarioProfesionalRepository;
    }

    public List<HorarioProfesional> listarTodos() {
        return horarioProfesionalRepository.findAll();
    }

    public HorarioProfesional buscarPorId(Long idHorarioProfesional) {
        return horarioProfesionalRepository.findById(idHorarioProfesional)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No se encontro el horario profesional con id " + idHorarioProfesional
                ));
    }

    public HorarioProfesional agregar(AgregarHorarioProfesional request) {
        HorarioProfesional horarioProfesional = new HorarioProfesional();
        horarioProfesional.setHoraInicio(request.getHoraInicio());
        horarioProfesional.setHoraFin(request.getHoraFin());
        return horarioProfesionalRepository.save(horarioProfesional);
    }

    public HorarioProfesional actualizar(Long idHorarioProfesional, ActualizarHorarioProfesional request) {
        HorarioProfesional horarioActual = buscarPorId(idHorarioProfesional);
        horarioActual.setHoraInicio(request.getHoraInicio());
        horarioActual.setHoraFin(request.getHoraFin());
        return horarioProfesionalRepository.save(horarioActual);
    }

    public void eliminar(Long idHorarioProfesional) {
        HorarioProfesional horarioProfesional = buscarPorId(idHorarioProfesional);
        horarioProfesionalRepository.delete(horarioProfesional);
    }
}
