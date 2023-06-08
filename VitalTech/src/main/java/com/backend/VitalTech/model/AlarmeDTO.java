package com.backend.VitalTech.model;

import com.fasterxml.jackson.datatype.jsr310.ser.OffsetTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
public class AlarmeDTO {
    private Long id;
    private Long id_Pacient;
    private String tip;
    private String pulsMinim;
    private String pulsMaxim;
    private OffsetDateTime data;

}
