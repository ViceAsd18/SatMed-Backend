package com.satmed.roles;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.satmed.roles.controller.RolController;
import com.satmed.roles.models.entities.Rol;
import com.satmed.roles.services.RolService;

/**
 * Test del endpoint GET /roles/{id}
 */
@WebMvcTest(RolController.class)
class RolControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Mock del servicio inyectado en el controlador.
     */
    @MockitoBean
    private RolService rolService;

    @Test
    void debeObtenerRolPorId() throws Exception {

        // Arrange: objeto de prueba
        Rol rol = new Rol();
        rol.setIdRol(1);
        rol.setNombreRol("ADMIN");

        // Configuración del mock
        when(rolService.obtenerRolPorId(1)).thenReturn(rol);

        // Act & Assert
        mockMvc.perform(get("/roles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idRol").value(1))
                .andExpect(jsonPath("$.nombreRol").value("ADMIN"));

        // Verify
        verify(rolService, times(1)).obtenerRolPorId(1);
    }
}