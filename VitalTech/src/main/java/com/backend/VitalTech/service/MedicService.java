package com.backend.VitalTech.service;


import com.backend.VitalTech.model.MedicDTO;

import java.util.List;

public interface MedicService {
    public List<MedicDTO> getMedici();
    public MedicDTO addMedic(MedicDTO medicDTO);
    public MedicDTO getMedicById(Long id);
    public void deleteMedic(Long id);
    public Long getMedicIdByEmail(String mail, String password);
    public MedicDTO getMedicByEmail(String mail, String password);
}
