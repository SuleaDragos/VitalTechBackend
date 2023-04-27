package com.backend.VitalTech.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Medic")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nume;
    @Column
    private String prenume;
    @Column
    private String parola;
    @OneToMany (mappedBy = "medic")
    private Set<Pacient> pacienti;

}
