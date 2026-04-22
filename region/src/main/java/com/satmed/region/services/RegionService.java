package com.satmed.region.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.region.models.entities.Region;
import com.satmed.region.repositories.RegionRepository;

@Service
public class RegionService {
    
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> obtenerRegiones() {
        return regionRepository.findAll();
    }

    public Region obtenerRegionPorId(Integer id) {
        Region regionEncontrada = regionRepository.findById(id).orElse(null);

        if (regionEncontrada == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Región con ID: " + id + " no encontrada");
        }

        return regionEncontrada;
    }
}
