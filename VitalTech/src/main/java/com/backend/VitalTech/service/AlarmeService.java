package com.backend.VitalTech.service;

import com.backend.VitalTech.model.AlarmeDTO;

import java.util.List;

public interface AlarmeService {
    public List<AlarmeDTO> getAlarmele();
    public List<AlarmeDTO> getAlarmeleByPacientId(Long id);
    public AlarmeDTO addAlarme(AlarmeDTO alarmeDTO);
    public AlarmeDTO getAlarmeById(Long id);
    public void deleteAlarme(Long id);
    public AlarmeDTO updateAlarme(Long id, AlarmeDTO alarmeDTO);
}
