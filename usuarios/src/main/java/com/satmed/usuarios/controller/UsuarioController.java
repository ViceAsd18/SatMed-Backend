package com.satmed.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satmed.usuarios.models.entities.Usuario;
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

    

}
