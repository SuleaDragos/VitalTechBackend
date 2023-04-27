package com.backend.VitalTech.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "DateMasurate")
public class DateMasurate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tip;
    private String valoare;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Pacient")
    private Pacient pacient;
}
