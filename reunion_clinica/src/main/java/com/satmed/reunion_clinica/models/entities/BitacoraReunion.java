package com.satmed.reunion_clinica.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bitacora_reunion")
public class BitacoraReunion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bitacora")
    private Long idBitacora;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "fecha_emision", nullable = false)
    private String fechaEmision;

    @ManyToOne
    @JoinColumn(name = "id_reunion", nullable = false)
    private ReunionClinica reunionClinica;

    @Column(name = "id_tipo_evento", nullable = false)
    private Long idTipoEvento;

}
