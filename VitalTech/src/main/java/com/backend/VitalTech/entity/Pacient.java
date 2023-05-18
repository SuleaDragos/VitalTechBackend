package com.backend.VitalTech.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Data
@Table(name = "pacient")
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String adresaMail;
    @Column
    private String parola;
    @Column
    private String nume;
    @Column
    private String prenume;
    @Column
    private Integer varsta;
    @Column
    private String cnp;
    @Column
    private String adresa;
    @Column
    private String numarTelefon;
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
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_Medic")
    private Medic medic;
    @OneToMany (mappedBy = "pacient")
    private Set<Alarme> alarme;
    @OneToMany (mappedBy = "pacient")
    private Set<Recomandari> recomandari;
    @OneToMany (mappedBy = "pacient")
    private Set<DateMasurate> dateMasurate;

}
