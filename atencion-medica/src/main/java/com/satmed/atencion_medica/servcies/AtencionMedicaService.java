package com.satmed.atencion_medica.servcies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.atencion_medica.models.AtencionMedica;
import com.satmed.atencion_medica.repositories.AtencionMedicaRepository;

@Service
public class AtencionMedicaService {
    
    @Autowired
    private AtencionMedicaRepository atencionMedicaRepository;

    public List<AtencionMedica> obtenerAtencionesMedicas(){
        return atencionMedicaRepository.findAll();
    }

    public AtencionMedica obtenerAtencionMedicaPorId(Integer idAtencionMedica){
        
        AtencionMedica atencionMedicaEncontrada = atencionMedicaRepository.findById(idAtencionMedica).orElse(null);

        if (atencionMedicaEncontrada == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"La Atencion medica con ID: " + idAtencionMedica + "No fue encontrada");
        }

        return  atencionMedicaEncontrada;

    }



}
