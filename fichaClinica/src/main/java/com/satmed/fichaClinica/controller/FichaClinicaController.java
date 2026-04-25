package com.satmed.fichaClinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.fichaClinica.models.entities.FichaClinica;
import com.satmed.fichaClinica.models.request.ActualizarFichaClinica;
import com.satmed.fichaClinica.models.request.AgregarFichaClinica;
import com.satmed.fichaClinica.services.FichaClinicaService;


@RestController
@RequestMapping("ficha-clinica")
public class FichaClinicaController {
    
    @Autowired
    private FichaClinicaService fichaClinicaService;


    @GetMapping("")
    public List<FichaClinica> obtenerFichasClinicas() {
        return fichaClinicaService.obtenerFichasClinicas();
    }
    
    @GetMapping("/{id}")
    public FichaClinica obtenerFichaClinicaPorId(@PathVariable Integer id) {
        return fichaClinicaService.obtenerFichaClinicaPorId(id);
    }

    @GetMapping("/paciente/{idPaciente}")
    public FichaClinica obtenerFichaClinicaPorPaciente(@PathVariable Integer idPaciente) {
        return fichaClinicaService.obtenerFichaClinicaPorIdPaciente(idPaciente);
    }

    @PostMapping
    public FichaClinica crearFichaClinica(@RequestBody AgregarFichaClinica fichaClinica) {
        return fichaClinicaService.crearFichaClinica(fichaClinica);
    }

    @PutMapping("/{id}")
    public FichaClinica actualizarFichaClinica(@PathVariable Integer id, @RequestBody ActualizarFichaClinica fichaClinica) {
        return fichaClinicaService.actualizarFichaClinica(id, fichaClinica);
    }
    


}
