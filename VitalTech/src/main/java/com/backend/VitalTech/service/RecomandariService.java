package com.backend.VitalTech.service;

import com.backend.VitalTech.model.RecomandariDTO;

import java.util.List;

public interface RecomandariService {
    public List<RecomandariDTO> getRecomandarile();
    public List<RecomandariDTO> getRecomandarileByPacientId(Long id);
    public RecomandariDTO addRecomandari(RecomandariDTO recomandariDTO);
    public RecomandariDTO getRecomandariById(Long id);
    public void deleteRecomandari(Long id);
}
