package com.satmed.publicacion.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.satmed.publicacion.exceptions.ResourceNotFoundException;
import com.satmed.publicacion.models.entities.Publicacion;
import com.satmed.publicacion.models.request.ActualizarPublicacion;
import com.satmed.publicacion.models.request.AgregarPublicacion;
import com.satmed.publicacion.repositories.PublicacionRepository;

@Service
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    // Inyección por constructor (igual que en DireccionService)
    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    public List<Publicacion> listarTodas() {
        return publicacionRepository.findAll();
    }

    public Publicacion buscarPorId(Long id) {
        return publicacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicación no encontrada con id: " + id));
    }

    public Publicacion crear(AgregarPublicacion request) {
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(request.getTitulo());
        publicacion.setContenido(request.getContenido());
        publicacion.setActivoPublicacion(request.getActivoPublicacion());
        // La fecha se genera sola en la entidad con @PrePersist si lo pusiste así
        return publicacionRepository.save(publicacion);
    }

    public Publicacion actualizar(Long id, ActualizarPublicacion request) {
        Publicacion publicacionExistente = buscarPorId(id);
        publicacionExistente.setTitulo(request.getTitulo());
        publicacionExistente.setContenido(request.getContenido());
        publicacionExistente.setActivoPublicacion(request.getActivoPublicacion());
        
        return publicacionRepository.save(publicacionExistente);
    }

    public void eliminar(Long id) {
        Publicacion publicacionExistente = buscarPorId(id);
        publicacionRepository.delete(publicacionExistente);
    }
}
