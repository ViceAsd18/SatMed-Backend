package com.satmed.region.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.region.models.entities.Region;
import com.satmed.region.models.request.ActualizarRegion;
import com.satmed.region.models.request.AgregarRegion;
import com.satmed.region.services.RegionService;

@RestController
@RequestMapping("regiones")
public class RegionController {
    
    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<Region> obtenerRegiones() {
        return regionService.obtenerRegiones();
    }

    @GetMapping("/{id}")
    public Region obtenerRegionPorId(@PathVariable Integer id) {
        return regionService.obtenerRegionPorId(id);
    }

    @PostMapping
    public Region agregarRegion(@RequestBody AgregarRegion region) {
        return regionService.agregarRegion(region);
    }

    @PutMapping
    public Region actualizarRegion(@RequestBody ActualizarRegion region) {
        return regionService.actualizarRegion(region.getIdRegion(), region);
    }

    @DeleteMapping("/{id}")
    public String eliminarRegion(@PathVariable Integer id) {
        return regionService.eliminarRegion(id);
    }

}
