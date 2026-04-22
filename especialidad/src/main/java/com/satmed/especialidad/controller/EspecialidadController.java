package com.satmed.especialidad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.especialidad.models.entities.Especialidad;
import com.satmed.especialidad.models.request.ActualizarEspecialidad;
import com.satmed.especialidad.models.request.AgregarEspecialidad;
import com.satmed.especialidad.services.EspecialidadService;

@RestController
@RequestMapping("especialidades")
public class EspecialidadController {
    
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> obtenerEspecialidades() {
        return especialidadService.obtenerEspecialidades();
    }

    @GetMapping("/{id}")
    public Especialidad obtenerEspecialidadPorId(@PathVariable Integer id) {
        return especialidadService.obtenerEspecialidadPorId(id);
    }

    @PostMapping
    public Especialidad agregarEspecialidad(@RequestBody AgregarEspecialidad especialidad) {
        return especialidadService.agregarEspecialidad(especialidad);
    }

    @PutMapping("/{id}")
    public Especialidad actualizarEspecialidad(@PathVariable Integer id, @RequestBody ActualizarEspecialidad especialidad) {
        return especialidadService.actualizarEspecialidad(id, especialidad);
    }

    @DeleteMapping("/{id}")
    public String eliminarEspecialidad(@PathVariable Integer id) {
        return especialidadService.eliminarEspecialidad(id);
    }

}
