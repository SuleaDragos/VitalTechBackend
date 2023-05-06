package com.backend.VitalTech.service;

import com.backend.VitalTech.entity.Pacient;
import com.backend.VitalTech.model.PacientDTO;

import java.util.List;

public interface PacientService {
    public List<PacientDTO> getPacienti();
    public PacientDTO addPacient(PacientDTO pacientDTO);
    public PacientDTO getPacientById(Long id);
    public void deletePacient(Long id);
}
