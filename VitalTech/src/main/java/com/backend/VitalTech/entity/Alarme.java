package com.backend.VitalTech.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Data
@Table(name = "alarma")
public class Alarme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String tip;
    @Column
    private String pulsMinim;
    @Column
    private String pulsMaxim;
    @Column
    private OffsetDateTime data;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_Pacient")
    private Pacient pacient;
}
