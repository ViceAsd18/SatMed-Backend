package com.satmed.direccion.services;

import com.satmed.direccion.exceptions.ResourceNotFoundException;
import com.satmed.direccion.models.entities.Direccion;
import com.satmed.direccion.models.request.ActualizarDireccion;
import com.satmed.direccion.models.request.AgregarDireccion;
import com.satmed.direccion.repositories.DireccionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public List<Direccion> listarTodas() {
        return direccionRepository.findAll();
    }

    public Direccion buscarPorId(Integer id) {
        return direccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Direccion no encontrada con id: " + id));
    }

    public Direccion crear(AgregarDireccion request) {
        Direccion direccion = new Direccion();
        direccion.setCalle(request.getCalle());
        direccion.setNumero(request.getNumero());
        return direccionRepository.save(direccion);
    }

    public Direccion actualizar(Integer id, ActualizarDireccion request) {
        Direccion direccionExistente = buscarPorId(id);
        direccionExistente.setCalle(request.getCalle());
        direccionExistente.setNumero(request.getNumero());
        return direccionRepository.save(direccionExistente);
    }

    public void eliminar(Integer id) {
        Direccion direccionExistente = buscarPorId(id);
        direccionRepository.delete(direccionExistente);
    }
}
