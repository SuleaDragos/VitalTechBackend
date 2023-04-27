package com.backend.VitalTech.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Recomandari")
public class Recomandari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String recomandare;
    @Column
    private String durataZilnica;
    @Column
    private String alteIndicatii;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Pacient")
    private Pacient pacient;

}
