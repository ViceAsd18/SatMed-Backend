package com.satmed.fichaClinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.fichaClinica.models.entities.FichaClinica;
import com.satmed.fichaClinica.models.request.ActualizarFichaClinica;
import com.satmed.fichaClinica.models.request.AgregarFichaClinica;
import com.satmed.fichaClinica.repositories.FichaClinicaRepository;

@Service
public class FichaClinicaService {
    
    @Autowired
    private FichaClinicaRepository fichaClinicaRepository;

    public List<FichaClinica> obtenerFichasClinicas() {
        return fichaClinicaRepository.findAll();
    }

    public FichaClinica obtenerFichaClinicaPorId(Integer id) {

        FichaClinica fichaClinica = fichaClinicaRepository.findById(id).orElse(null);

        if (fichaClinica == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"La ficha clinica con ID: " + id + " no fue encontrada");
        }

        return fichaClinica;

    }

    public FichaClinica obtenerFichaClinicaPorIdPaciente(Integer idPaciente) {

        FichaClinica fichaClinica = fichaClinicaRepository.findByIdPaciente(idPaciente);

        if (fichaClinica == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"La ficha clinica del paciente con ID: " + idPaciente + " no fue encontrada");
        }

        return fichaClinica;

    }



    public FichaClinica crearFichaClinica(AgregarFichaClinica nuevaFichaClinica) {

        
        if (fichaClinicaRepository.existsByIdPaciente(nuevaFichaClinica.getIdPaciente())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El paciente con ID: " + nuevaFichaClinica.getIdPaciente() + " ya tiene una ficha clinica registrada");
        }

        FichaClinica ficha = new FichaClinica();
        ficha.setIdPaciente(nuevaFichaClinica.getIdPaciente());
        ficha.setObservaciones(nuevaFichaClinica.getObservaciones());
        ficha.setActiva(true);

        return fichaClinicaRepository.save(ficha);


    }

    public FichaClinica actualizarFichaClinica(Integer id, ActualizarFichaClinica fichaActualizada){

        FichaClinica fichaClinica = fichaClinicaRepository.findById(id).orElse(null);

        if (fichaClinica == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"La ficha clinica con ID: " + id + " no fue encontrada");
        }

        fichaClinica.setObservaciones(fichaActualizada.getObservaciones());
        fichaClinica.setActiva(fichaActualizada.getActiva());

        return fichaClinicaRepository.save(fichaClinica);


    }



}
