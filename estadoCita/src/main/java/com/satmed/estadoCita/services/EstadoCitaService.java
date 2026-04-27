package com.satmed.estadoCita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satmed.estadoCita.models.entities.EstadoCita;
import com.satmed.estadoCita.repositories.EstadoCitaRepository;

@Service
public class EstadoCitaService {

    @Autowired
    private EstadoCitaRepository estadoCitaRepository;

    public List<EstadoCita> obtenerTodosEstadosCita() {
        return estadoCitaRepository.findAll();
    }

    public List<EstadoCita> buscarPorNombre(String nombre) {
        return estadoCitaRepository.findByNombreEstadoCitaContainingIgnoreCase(nombre);
    }

}
