package com.backend.VitalTech.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "Pacient")
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nume;
    @Column
    private String prenume;
    @Column
    private String parola;
    @Column
    private Integer varsta;
    @Column
    private String cnp;
    @Column
    private String adresa;
    @Column
    private String numarTelefon;
    @Column
    private String adresaMail;
    @Column
    private String profesie;
    @Column
    private String locDeMunca;
    @Column
    private String istoricMedical;
    @Column
    private String alergii;
    @Column
    private String consultatiCardiologice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Medic")
    private Medic medic;
    @OneToMany (mappedBy = "pacient")
    private Set<Alarme> alarme;
    @OneToMany (mappedBy = "pacient")
    private Set<Recomandari> recomandari;
    @OneToMany (mappedBy = "pacient")
    private Set<DateMasurate> dateMasurate;

}