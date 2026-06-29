package com.satmed.direccion.services;

import com.satmed.direccion.exceptions.ResourceNotFoundException;
import com.satmed.direccion.models.dto.ComunaDto;
import com.satmed.direccion.models.entities.Direccion;
import com.satmed.direccion.models.request.ActualizarDireccion;
import com.satmed.direccion.models.request.AgregarDireccion;
import com.satmed.direccion.repositories.DireccionRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private WebClient comunaWebClient;

    public List<Direccion> listarTodas() {
        return direccionRepository.findAll();
    }

    public Direccion buscarPorId(Integer id) {
        return direccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Direccion no encontrada con id: " + id));
    }

    public Direccion crearDireccion(AgregarDireccion request) {
        validarComuna(request.getIdComuna());

        Direccion direccion = new Direccion();
        direccion.setCalleDireccion(request.getCalleDireccion());
        direccion.setNumeroDireccion(request.getNumeroDireccion());
        direccion.setIdComuna(request.getIdComuna());
        return direccionRepository.save(direccion);
    }

    public Direccion actualizar(Integer id, ActualizarDireccion request) {
        
        Direccion direccionExistente = buscarPorId(id);
        
        validarComuna(request.getIdComuna());

        direccionExistente.setCalleDireccion(request.getCalleDireccion());
        direccionExistente.setNumeroDireccion(request.getNumeroDireccion());
        direccionExistente.setIdComuna(request.getIdComuna());
        return direccionRepository.save(direccionExistente);
    }



    public String eliminar(Integer id) {
        Direccion direccionExistente = buscarPorId(id);
        direccionRepository.delete(direccionExistente);
        return "Direccion eliminada correctamente";     
    }



    //MÉTODO DE APOYO
    private void validarComuna(Integer idComuna) {
        try {
            comunaWebClient.get()
                .uri("/comunas/{id}", idComuna)
                .retrieve()
                .bodyToMono(ComunaDto.class)
                .block();
        } catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La comuna con ID " + idComuna + " no existe.");
            }
            // Error genérico por si falla el MS de Comunas (500, etc)
            throw new ResponseStatusException(e.getStatusCode(), "Error en el microservicio de Comunas.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Servicio de Comunas fuera de línea.");
        }
    }

}
