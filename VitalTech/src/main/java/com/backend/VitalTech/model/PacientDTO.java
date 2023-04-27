package com.backend.VitalTech.model;

import lombok.Data;

@Data
public class PacientDTO {
    private Long id;
    private Long id_Medic;
    private String nume;
    private String prenume;
    private String parola;
    private Integer varsta;
    private String cnp;
    private String adresa;
    private String numarTelefon;
    private String adresaMail;
    private String profesie;
    private String locDeMunca;
    private String istoricMedical;
    private String alergii;
    private String consultatiiCardiologice;


}
