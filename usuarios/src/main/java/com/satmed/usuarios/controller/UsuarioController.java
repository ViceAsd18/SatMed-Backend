package com.satmed.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.usuarios.models.entities.Usuario;
import com.satmed.usuarios.models.request.ActualizarUsuario;
import com.satmed.usuarios.models.request.AgregarUsuario;
import com.satmed.usuarios.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public List<Usuario> obtenerTodosLosUsuarios(){
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public Usuario obtenerUsuarioPorId(@PathVariable Integer idUsuario){
        return usuarioService.obtenerUsuarioPorId(idUsuario);
    }

    @GetMapping("/rut/{rutUsuario}")
    public Usuario obtenerUsuarioPorRut(@PathVariable String rutUsuario){
        return usuarioService.obtenerUsuarioPorRut(rutUsuario);
    }

    @GetMapping("/email/{emailUsuario}")
    public Usuario obtenerUsuarioPorEmail(@PathVariable String emailUsuario){
        return usuarioService.obtenerUsuarioPorEmail(emailUsuario);
    }

    @PostMapping("")
    public Usuario agregarUsuario(@RequestBody AgregarUsuario request) {
        return usuarioService.agregarUsuario(request);
    }

    @PutMapping("/{idUsuario}")
    public Usuario actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody ActualizarUsuario request) {
        return usuarioService.actualizarUsuario(idUsuario, request);
    }

    @DeleteMapping("/{idUsuario}")
    public String eliminarUsuario(@PathVariable Integer idUsuario) {
        return usuarioService.eliminarUsuario(idUsuario);
    }

    

}
