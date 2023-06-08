package com.backend.VitalTech.service;

import com.backend.VitalTech.entity.Pacient;
import com.backend.VitalTech.model.PacientDTO;

import java.util.List;

public interface PacientService {
    public List<PacientDTO> getPacienti();
    public List<PacientDTO> getPacientiByMeidcId(Long id);
    public PacientDTO addPacient(PacientDTO pacientDTO);
    public PacientDTO getPacientById(Long id);
    public void deletePacient(Long id);
    public Long getPacientIdByEmail(String mail, String password);
    public PacientDTO getPacientByEmail(String mail, String Password);
    public PacientDTO updatePacient(Long id,PacientDTO pacientDTO);
}
