package com.satmed.tratamiento.controller;

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

import com.satmed.tratamiento.models.entities.Tratamiento;
import com.satmed.tratamiento.models.request.ActualizarTratamiento;
import com.satmed.tratamiento.models.request.AgregarTratamiento;
import com.satmed.tratamiento.services.TratamientoService;

@RestController
@RequestMapping("tratamiento")
public class TratamientoController {
    
    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("")
    public List<Tratamiento> obtenerTratamientos(){
        return tratamientoService.obtenerTratamientos();
    }

    @GetMapping("/{id}")
    public Tratamiento obtenerTratamiento(@PathVariable Integer id){
        return tratamientoService.obtenerTratamientoPorId(id);
    }

    @GetMapping("/atencion-medica/{idAtencionMedica}")
    public List<Tratamiento> obtenerTratamientoPorIdAtencionMedica(@PathVariable Integer idAtencionMedica){
        return tratamientoService.obtenerTratamientosPorAtencionMedica(idAtencionMedica);
    }

    @PostMapping("")
    public Tratamiento crearTratamiento(@RequestBody AgregarTratamiento tratamiento){
        return tratamientoService.crearTratamiento(tratamiento);
    }

    @PutMapping("/{id}")
    public Tratamiento actualizarTratamiento(@PathVariable Integer id, @RequestBody ActualizarTratamiento tratamiento){
        return tratamientoService.actualizarTratamiento(id, tratamiento);
    }

    @DeleteMapping ("/{id}")
    public void eliminarTratamiento(@PathVariable Integer id){
        tratamientoService.eliminarTratamiento(id);
    }

}
