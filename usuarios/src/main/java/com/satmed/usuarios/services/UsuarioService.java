package com.satmed.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.satmed.usuarios.models.dto.DireccionDto;
import com.satmed.usuarios.models.entities.Usuario;
import com.satmed.usuarios.models.request.AgregarDireccion;
import com.satmed.usuarios.models.request.AgregarUsuario;
import com.satmed.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private WebClient generoWebClient;  

    @Autowired
    private WebClient rolWebClient;

    @Autowired
    private WebClient direccionWebClient;


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

        DireccionDto direccion = null;

        validarGenero(usuarioRequest.getIdGenero());
        validarRol(usuarioRequest.getIdRol());

        //Crear Direccion para el usuario, conexion con Microservicio Direcciones
        AgregarDireccion direccionRequest = new AgregarDireccion(); 
        direccionRequest.setCalleDireccion(usuarioRequest.getCalleDireccion());
        direccionRequest.setNumeroDireccion(usuarioRequest.getNumeroDireccion());
        direccionRequest.setIdComuna(usuarioRequest.getIdComuna());

        try {
            direccion = direccionWebClient.post()
                .uri("/direcciones")
                .bodyValue(direccionRequest)
                .retrieve()
                .bodyToMono(DireccionDto.class)
                .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(e.getStatusCode(), "Error al conectarse con Microservicio direcciones: " + e.getResponseBodyAsString());            
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Microservicio Direcciones apagado.");
        }

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

        usuarioNuevo.setIdGenero(usuarioRequest.getIdGenero());
        usuarioNuevo.setIdRol(usuarioRequest.getIdRol());
        usuarioNuevo.setIdDireccion(direccion.idDireccion());

        return usuarioRepository.save(usuarioNuevo);   
    }


    //ActualizarUsuario
    



    //Se elimina el usuario pero se mantiene en la base de datos, se cambia su estado a inactivo
    public String eliminarUsuario(Integer idUsuario){
        Usuario usuarioEncontrado = usuarioRepository.findById(idUsuario).orElse(null);

        if (usuarioEncontrado == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario con id: " +  idUsuario + " no fue encontrado");
        }

    /* 
     * BORRADO LÓGICO:
     * No eliminamos el registro físicamente para mantener la integridad referencial 
     * y el historial clínico en SatMed. Si el usuario tiene citas o recetas 
     * asociadas, un borrado físico (DELETE) causaría errores de llave foránea.
    */

        usuarioEncontrado.setActivo(false);
        usuarioRepository.save(usuarioEncontrado);

        return "Usuario con ID: " + idUsuario + " eliminado exitosamente";
    }



    //Metodos de APOYO
    private void validarGenero(Integer idGenero) {
        try {
            generoWebClient.get()
                .uri("/generos/{id}", idGenero)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Género con id: " + idGenero + " no encontrado.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Microservicio Géneros apagado.");
        }
    }

    private void validarRol(Integer idRol) {
        try {
            rolWebClient.get()
                .uri("/roles/{id}", idRol)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rol con id: " + idRol + " no encontrado.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Microservicio Roles apagado.");
        }
    }








}
