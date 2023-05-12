package com.backend.VitalTech.service_implementation;

import com.backend.VitalTech.Transformer;
import com.backend.VitalTech.entity.DateMasurate;
import com.backend.VitalTech.model.DateMasurateDTO;
import com.backend.VitalTech.repository.DateMasurateRepository;
import com.backend.VitalTech.repository.PacientRepository;
import com.backend.VitalTech.service.DateMasurateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DateMasurateServiceImpl implements DateMasurateService {
    private final DateMasurateRepository dateMasurateRepository;
    private final PacientRepository pacientRepository;
    public List<DateMasurateDTO> getDateMasuratele()
    {
        return dateMasurateRepository.findAll().stream().map(Transformer::toDto).toList();
    }
    public List<DateMasurateDTO> getDateMasurateleByPacientId(Long id){
        return dateMasurateRepository.findAllByPacientId(id).stream().map(Transformer::toDto).toList();
    }
    public DateMasurateDTO addDateMasurate(DateMasurateDTO dateMasurateDTO)  // adaugarea asta e mai mare pentru ca trebuie referentiat pacientul
    {
        var pacient = pacientRepository.findById(dateMasurateDTO.getId_Pacient());
        if(pacient.isPresent()) {
            var dateMasurate = new DateMasurate();
            dateMasurate.setTip(dateMasurateDTO.getTip());
            dateMasurate.setValoare(dateMasurateDTO.getValoare());
            dateMasurate.setPacient(pacient.get());
            return Transformer.toDto(dateMasurateRepository.save(dateMasurate));
        }
        return new DateMasurateDTO();
    }
    public DateMasurateDTO getDateMasurateById(Long id)
    {
        return Transformer.toDto(dateMasurateRepository.getReferenceById(id));
    }
    public void deleteDateMasurate(Long id)
    {
        dateMasurateRepository.deleteById(id);
    }
}
