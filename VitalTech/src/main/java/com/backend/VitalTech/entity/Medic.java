package com.backend.VitalTech.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "medic")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String adresaMail;
    @Column
    private String parola;
    @Column
    private String nume;
    @Column
    private String prenume;
    @OneToMany (mappedBy = "medic")
    private Set<Pacient> pacienti;

}
