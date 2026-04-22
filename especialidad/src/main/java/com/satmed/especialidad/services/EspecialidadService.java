package com.satmed.especialidad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.especialidad.models.entities.Especialidad;
import com.satmed.especialidad.models.request.ActualizarEspecialidad;
import com.satmed.especialidad.models.request.AgregarEspecialidad;
import com.satmed.especialidad.repositories.EspecialidadRepository;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

     public List<Especialidad> obtenerEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Especialidad obtenerEspecialidadPorId(Integer id) {

        Especialidad especialidadEncontrada = especialidadRepository.findById(id).orElse(null);

        if (especialidadEncontrada == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidad con ID: " + id + " no encontrada");
        }

        return especialidadEncontrada;

    }

    public Especialidad agregarEspecialidad(AgregarEspecialidad especialidad) {

        Especialidad nuevaEspecialidad = new Especialidad();
        nuevaEspecialidad.setNombreEspecialidad(especialidad.getNombreEspecialidad());
        return especialidadRepository.save(nuevaEspecialidad);

    }

    public Especialidad actualizarEspecialidad(Integer id, ActualizarEspecialidad especialidad) {

        Especialidad especialidadExistente = especialidadRepository.findById(id).orElse(null);

        if (especialidadExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidad con ID: " + id + " no encontrada");
        }

        especialidadExistente.setNombreEspecialidad(especialidad.getNombreEspecialidad());
        return especialidadRepository.save(especialidadExistente);

    }

    public String eliminarEspecialidad(Integer id) {

        Especialidad especialidadExistente = especialidadRepository.findById(id).orElse(null);

        if (especialidadExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidad con ID: " + id + " no encontrada");
        }

        especialidadRepository.deleteById(id);
        return "Especialidad con ID: " + id + " eliminada correctamente";

    }

}
