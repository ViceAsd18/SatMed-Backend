package com.satmed.microservicioadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.satmed.microservicioadmin.models.entities.Usuario;
import com.satmed.microservicioadmin.models.request.UsuarioRequest;
import com.satmed.microservicioadmin.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    @Transactional
    public Usuario guardar(UsuarioRequest request) {
        Usuario usuario = mapToEntity(new Usuario(), request);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Optional<Usuario> actualizar(Long idUsuario, UsuarioRequest request) {
        return usuarioRepository.findById(idUsuario).map(usuario -> {
            mapToEntity(usuario, request);
            return usuarioRepository.save(usuario);
        });
    }

    @Transactional
    public boolean eliminar(Long idUsuario) {
        if (!usuarioRepository.existsById(idUsuario)) {
            return false;
        }
        usuarioRepository.deleteById(idUsuario);
        return true;
    }

    private Usuario mapToEntity(Usuario usuario, UsuarioRequest request) {
        usuario.setRut(request.getRut());
        usuario.setPnombreUsu(request.getPnombreUsu());
        usuario.setSnombreUsu(request.getSnombreUsu());
        usuario.setApaternoUsu(request.getApaternoUsu());
        usuario.setAmaternoUsu(request.getAmaternoUsu());
        usuario.setEmailUsuario(request.getEmailUsuario());
        usuario.setTelefono(request.getTelefono());
        usuario.setFechaNacimiento(request.getFechaNacimiento());
        usuario.setContrasena(request.getContrasena());
        usuario.setActivo(request.getActivo());
        usuario.setFechaRegistro(request.getFechaRegistro());
        usuario.setGeneroIdGenero(request.getGeneroIdGenero());
        usuario.setDireccionIdDireccion(request.getDireccionIdDireccion());
        usuario.setPacienteIdPaciente(request.getPacienteIdPaciente());
        usuario.setRolRolId(request.getRolRolId());
        return usuario;
    }
}
