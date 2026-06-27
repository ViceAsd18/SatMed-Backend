package com.satmed.atencion_medica.services;

import java.util.List;

import com.satmed.atencion_medica.models.entities.AtencionMedica;

public interface AtencionMedicaService {
    List<AtencionMedica> obtenerAtencionMedica();
    AtencionMedica obtenerAtencionMedicaPorId(Integer id);
}