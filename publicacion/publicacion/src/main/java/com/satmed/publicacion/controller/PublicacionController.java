package com.satmed.publicacion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.publicacion.models.entities.Publicacion;
import com.satmed.publicacion.models.request.ActualizarPublicacion;
import com.satmed.publicacion.models.request.AgregarPublicacion;
import com.satmed.publicacion.services.PublicacionService;

@RestController
@RequestMapping("/api/publicacion")
@CrossOrigin(origins = "*")
public class PublicacionController {

    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Publicacion> listar() {
        return publicacionService.listarTodas();
    }

    // OBTENER
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(publicacionService.buscarPorId(id));
    }

    // AGREGAR
    @PostMapping("/agregar")
    @ResponseStatus(HttpStatus.CREATED)
    public Publicacion crear(@RequestBody AgregarPublicacion request) {
        return publicacionService.crear(request);
    }

    // ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Publicacion> actualizar(@PathVariable Long id, @RequestBody ActualizarPublicacion request) {
        return ResponseEntity.ok(publicacionService.actualizar(id, request));
    }

    // ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        publicacionService.eliminar(id);
    }
}
