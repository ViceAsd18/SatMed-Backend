package com.satmed.comuna.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.comuna.repositories.ComunaRepository;
import com.satmed.comuna.models.dto.RegionDto;
import com.satmed.comuna.models.entities.Comuna;


@Service
public class ComunaService {
    
    @Autowired
    private ComunaRepository comunaRepository;

    @Autowired
    private WebClient regionWebClient;

    public List<Comuna> obtenerComunas() {
        return comunaRepository.findAll();
    }

    public Comuna obtenerComunaPorId(Integer id) {
        Comuna comunaEncontrada = comunaRepository.findById(id).orElse(null);

        if (comunaEncontrada == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comuna con ID: " + id + " no encontrada");
        }

        return comunaEncontrada;
    }

    public List<Comuna> obtenerComunasPorRegion(Integer idRegion) {

        RegionDto region = null;

        try {
            region = regionWebClient.get()
                    .uri("/region/" + idRegion)
                    .retrieve()
                    .bodyToMono(RegionDto.class)
                    .block();

            if (region == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Región con ID: " + idRegion + " no encontrada");
            }

        } catch (WebClientResponseException e){
            throw new ResponseStatusException(
                HttpStatus.valueOf(e.getStatusCode().value()),
                "Error al obtener la región: " + e.getResponseBodyAsString());
        } catch (Exception e ) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Servicio de regiones no disponible: " + e.getMessage()); 
        } 


        return comunaRepository.findByIdRegion(idRegion);
    }

}
