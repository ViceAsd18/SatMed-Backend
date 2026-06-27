package com.satmed.atencion_medica.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.satmed.atencion_medica.models.entities.AtencionMedica;

@Service
public class AtencionMedicaServiceImpl implements AtencionMedicaService {

    @Override
    public List<AtencionMedica> obtenerAtencionMedica() {
        return new ArrayList<>();
    }

    @Override
    public AtencionMedica obtenerAtencionMedicaPorId(Integer id) {
        return new AtencionMedica();
    }
}
