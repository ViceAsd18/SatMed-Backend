package com.satmed.roles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.roles.models.entities.Rol;
import com.satmed.roles.models.request.ActualizarRol;
import com.satmed.roles.models.request.AgregarRol;
import com.satmed.roles.repositories.RolRepository;

@Service
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerRoles() {
        return rolRepository.findAll(); 
    }

    public Rol obtenerRolPorId(Integer id) {
    
        Rol rolEncontrado = rolRepository.findById(id).orElse(null);

        if (rolEncontrado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol con ID: " + id + " no encontrado");
        }

        return rolEncontrado;
    
    }


    public Rol agregarRol(AgregarRol rol){

        Rol nuevoRol = new Rol();
        nuevoRol.setNombreRol(rol.getNombreRol());
        return rolRepository.save(nuevoRol);

    }

    public Rol actualizarRol(Integer id, ActualizarRol rol) {
        
        Rol rolExistente = rolRepository.findById(id).orElse(null);

        if (rolExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol con ID: " + id + " no encontrado");
        }

        rolExistente.setNombreRol(rol.getNombreRol());
        return rolRepository.save(rolExistente);
    }




    public String eliminarRol(Integer id){
        Rol rolExistente = rolRepository.findById(id).orElse(null);

        if (rolExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol con ID: " + id + " no encontrado");

        }

        rolRepository.deleteById(id);
        return "Rol con ID: " + id + " eliminado correctamente";
    }


}
