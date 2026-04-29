package com.satmed.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.usuarios.models.entities.Usuario;
import com.satmed.usuarios.models.request.AgregarUsuario;
import com.satmed.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorRut(String rutUsuario) {

        Usuario usuarioEncontrado = usuarioRepository.findByRutUsuario(rutUsuario).orElse(null);

        if(usuarioEncontrado == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario con rut: " +  rutUsuario + " no fue encontrado");
        }

        return usuarioEncontrado;
    }

    public Usuario obtenerUsuarioPorEmail(String emailUsuario) {

        Usuario usuarioEncontrado = usuarioRepository.findByEmailUsuario(emailUsuario).orElse(null);

        if(usuarioEncontrado == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario con email: " +  emailUsuario + " no fue encontrado");
        }

        return usuarioEncontrado;
    }
    
    public Usuario obtenerUsuarioPorId(Integer idUsuaario){

        Usuario usuarioEncontado = usuarioRepository.findById(idUsuaario).orElse(null);

        if (usuarioEncontado == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario con id: " +  idUsuaario + " no fue encontrado");
        }

        return usuarioEncontado;

    }

    public Usuario agregarUsuario(AgregarUsuario usuarioRequest){

        Usuario usuarioNuevo = new Usuario();

        usuarioNuevo.setRutUsuario(usuarioRequest.getRutUsuario());
        usuarioNuevo.setPnombreUsuario(usuarioRequest.getPnombreUsuario());
        usuarioNuevo.setSnombreUsuario(usuarioRequest.getSnombreUsuario());
        usuarioNuevo.setApaternoUsuario(usuarioRequest.getApaternoUsuario());
        usuarioNuevo.setAmaternoUsuario(usuarioRequest.getAmaternoUsuario());
        usuarioNuevo.setEmailUsuario(usuarioRequest.getEmailUsuario());
        usuarioNuevo.setTelefonoUsuario(usuarioRequest.getTelefonoUsuario());
        usuarioNuevo.setFechaNacimientoUsuario(usuarioRequest.getFechaNacimientoUsuario());
        usuarioNuevo.setContrasenaUsuario(usuarioRequest.getContrasenaUsuario());
        usuarioNuevo.setActivo(true);

        //Id Rol

        //ID genero

        //ID Direccion

        return usuarioRepository.save(usuarioNuevo);   
    }



}
