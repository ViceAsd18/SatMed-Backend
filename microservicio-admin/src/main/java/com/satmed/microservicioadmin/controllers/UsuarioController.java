package com.satmed.microservicioadmin.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.satmed.microservicioadmin.models.entities.Usuario;
import com.satmed.microservicioadmin.models.request.UsuarioRequest;
import com.satmed.microservicioadmin.services.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long idUsuario) {
        return usuarioService.buscarPorId(idUsuario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/agregar")
    public ResponseEntity<Usuario> agregar(@RequestBody UsuarioRequest request) {
        Usuario usuarioCreado = usuarioService.guardar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

    @PutMapping("/actualizar/{idUsuario}")
    public ResponseEntity<Usuario> actualizar(
            @PathVariable Long idUsuario,
            @RequestBody UsuarioRequest request) {
        return usuarioService.actualizar(idUsuario, request)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idUsuario) {
        if (!usuarioService.eliminar(idUsuario)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
