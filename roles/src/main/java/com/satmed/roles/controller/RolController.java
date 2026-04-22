package com.satmed.roles.controller;

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

import com.satmed.roles.models.entities.Rol;
import com.satmed.roles.models.request.ActualizarRol;
import com.satmed.roles.models.request.AgregarRol;
import com.satmed.roles.services.RolService;

@RestController
@RequestMapping("roles")
public class RolController {
    
    @Autowired
    private RolService rolService;

    @GetMapping("")
    public List<Rol> obtenerRoles() {
        return rolService.obtenerRoles();
    }

    @GetMapping("/{id}")
    public Rol obtenerRolPorId(@PathVariable int id) {
        return rolService.obtenerRolPorId(id);
    }
    
    @PostMapping("")
    public Rol agregarRol(@RequestBody AgregarRol rol) {
        return rolService.agregarRol(rol);
    }

    @PutMapping("")
    public Rol actualizarRol(@RequestBody ActualizarRol rol) {
        return rolService.actualizarRol(rol.getIdRol(), rol);
    }


    @DeleteMapping("/{id}")
    public String eliminarRol(@PathVariable int id) {
        return rolService.eliminarRol(id);
    }

}
