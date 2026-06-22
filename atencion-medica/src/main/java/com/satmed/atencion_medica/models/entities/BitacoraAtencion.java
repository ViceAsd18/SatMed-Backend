package com.satmed.atencion_medica.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BITACORA_ATENCION")
public class BitacoraAtencion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bitacora_atencion")
    private Long idBitacoraAtencion;

    @Column(name = "fecha_hora_realizada", nullable = false)
    private String fechaHoraRealizada;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "id_tipo_evento", nullable = false)
    private Long idTipoEvento;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_atencion", nullable = false)
    private AtencionMedica atencionMedica;

}
