package com.satmed.region.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.region.models.entities.Region;
import com.satmed.region.services.RegionService;

@RestController
@RequestMapping("regiones")
public class RegionController {
    
    
    @Autowired
    private RegionService regionService;

    @GetMapping("")
    public List<Region> obtenerRegiones() {
        return regionService.obtenerRegiones();
    }

    @GetMapping("/{id}")
    public Region obtenerRegionPorId(@PathVariable Integer id) {
        return regionService.obtenerRegionPorId(id);
    }

}
