package com.backend.VitalTech.service;

import com.backend.VitalTech.model.DateMasurateDTO;

import java.util.List;

public interface DateMasurateService {
    public List<DateMasurateDTO> getDateMasuratele();
    public List<DateMasurateDTO> getDateMasurateleByPacientId(Long id);
    public DateMasurateDTO addDateMasurate(DateMasurateDTO dateMasurateDTO);
    public DateMasurateDTO getDateMasurateById(Long id);
    public void deleteDateMasurate(Long id);
}
