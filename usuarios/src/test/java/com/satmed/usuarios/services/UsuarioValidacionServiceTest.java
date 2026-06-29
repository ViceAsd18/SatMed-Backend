package com.satmed.usuarios.services;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension; 

@ExtendWith(MockitoExtension.class) //[cite: 1]
public class UsuarioValidacionServiceTest {

    // Instancia única y final como en la clase del video[cite: 1]
    private final UsuarioValidacionService validacionService = new UsuarioValidacionService();

    @Test //[cite: 1]
    public void probandoCorreoInstitucionalValido() {
        // Ejecutamos el método[cite: 1]
        boolean resultado = validacionService.esCorreoInstitucional("li.granadillo@duocuc.cl");

        // Verificamos el resultado esperado[cite: 1]
        assertThat(resultado).isEqualTo(true);
    }

    @Test //[cite: 1]
    public void probandoCorreoInvalidoDebeFallar() {
        // Ejecutamos con un correo que no corresponde[cite: 1]
        boolean resultado = validacionService.esCorreoInstitucional("usuario@gmail.com");

        // Verificamos que sea falso[cite: 1]
        assertThat(resultado).isEqualTo(false);
    }
}