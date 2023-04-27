package com.backend.VitalTech.model;

import lombok.Data;

@Data
public class DateMasurateDTO {
    private Long id;
    private Long id_Pacient;
    private String tip;
    private String valoare;
}
