package com.backend.VitalTech.model;

import lombok.Data;

@Data
public class RecomandariDTO {
    private Long id;
    private Long id_Pacient;
    private String recomandare;
    private String durataZilnica;
    private String alteIndicatii;
}
