package com.satmed.horarioProfesional.controllers;

import com.satmed.horarioProfesional.models.entities.HorarioProfesional;
import com.satmed.horarioProfesional.models.request.ActualizarHorarioProfesional;
import com.satmed.horarioProfesional.models.request.AgregarHorarioProfesional;
import com.satmed.horarioProfesional.services.HorarioProfesionalService;
import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping("/api/horario-profesional")
@CrossOrigin
public class HorarioProfesionalController {

    private final HorarioProfesionalService horarioProfesionalService;

    public HorarioProfesionalController(HorarioProfesionalService horarioProfesionalService) {
        this.horarioProfesionalService = horarioProfesionalService;
    }

    @GetMapping
    public List<HorarioProfesional> listarTodos() {
        return horarioProfesionalService.listarTodos();
    }

    @GetMapping("/{idHorarioProfesional}")
    public HorarioProfesional buscarPorId(@PathVariable Long idHorarioProfesional) {
        return horarioProfesionalService.buscarPorId(idHorarioProfesional);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HorarioProfesional agregar(@Valid @RequestBody AgregarHorarioProfesional request) {
        return horarioProfesionalService.agregar(request);
    }

    @PutMapping("/{idHorarioProfesional}")
    public HorarioProfesional actualizar(
            @PathVariable Long idHorarioProfesional,
            @Valid @RequestBody ActualizarHorarioProfesional request
    ) {
        return horarioProfesionalService.actualizar(idHorarioProfesional, request);
    }

    @DeleteMapping("/{idHorarioProfesional}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long idHorarioProfesional) {
        horarioProfesionalService.eliminar(idHorarioProfesional);
    }
}
