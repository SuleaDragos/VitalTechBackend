package com.backend.VitalTech.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Data
@Table(name = "Alarme")
public class Alarme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tip;
    @Column
    private String problema;
    @Column
    private OffsetDateTime data;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Pacient")
    private Pacient pacient;
}
