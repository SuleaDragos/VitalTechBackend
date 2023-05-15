package com.backend.VitalTech.model;

import lombok.Data;

@Data
public class PacientDTO {
    private Long id;
    private String adresaMail;
    private String parola;
    private Long id_Medic;
    private String nume;
    private String prenume;
    private Integer varsta;
    private String cnp;
    private String adresa;
    private String numarTelefon;
    private String profesie;
    private String locDeMunca;
    private String istoricMedical;
    private String alergii;
    private String consultatiiCardiologice;


}
