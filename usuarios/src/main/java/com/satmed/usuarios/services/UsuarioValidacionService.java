package com.satmed.usuarios.services;

import org.springframework.stereotype.Service;

@Service
public class UsuarioValidacionService {

    // Un método simple, tal como el del profesor, para entender el concepto
    public boolean esCorreoInstitucional(String correo) {
        if (correo == null) {
            return false;
        }
        // Valida si el correo termina con el dominio permitido
        return correo.endsWith("@duocuc.cl") || correo.endsWith("@satmed.com");
    }
}