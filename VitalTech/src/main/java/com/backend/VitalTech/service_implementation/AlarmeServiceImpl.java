package com.backend.VitalTech.service_implementation;

import com.backend.VitalTech.Transformer;
import com.backend.VitalTech.entity.Alarme;
import com.backend.VitalTech.entity.Pacient;
import com.backend.VitalTech.model.AlarmeDTO;
import com.backend.VitalTech.model.PacientDTO;
import com.backend.VitalTech.repository.AlarmeRepository;
import com.backend.VitalTech.repository.PacientRepository;
import com.backend.VitalTech.service.AlarmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlarmeServiceImpl implements AlarmeService {
    private final AlarmeRepository alarmeRepository;
    private final PacientRepository pacientRepository;
    public List<AlarmeDTO> getAlarmele() {
        return alarmeRepository.findAll().stream().map(Transformer::toDto).toList();
    }
    public List<AlarmeDTO> getAlarmeleByPacientId(Long id){
        return alarmeRepository.findAllByPacientId(id).stream().map(Transformer::toDto).toList();
    }
    public AlarmeDTO addAlarme(AlarmeDTO alarmeDTO)  // adaugarea asta e mai mare pentru ca trebuie referentiat pacientul
    {
        var pacient = pacientRepository.findById(alarmeDTO.getId_Pacient());
        if(pacient.isPresent()) {
            var alarme = new Alarme();
            alarme.setTip(alarmeDTO.getTip());
            alarme.setData(alarmeDTO.getData());
            alarme.setPulsMinim(alarmeDTO.getPulsMinim());
            alarme.setPulsMaxim(alarmeDTO.getPulsMaxim());
            alarme.setPacient(pacient.get());
            return Transformer.toDto(alarmeRepository.save(alarme));
        }
        return new AlarmeDTO();
    }
    public AlarmeDTO getAlarmeById(Long id)
    {
        return Transformer.toDto(alarmeRepository.getReferenceById(id));
    }
    public void deleteAlarme(Long id)
    {
        alarmeRepository.deleteById(id);
    }
    public AlarmeDTO updateAlarme(Long id, AlarmeDTO alarmeDTO) {
        var alarmeData = alarmeRepository.findById(id);
        Alarme alarme = alarmeData.get();
        alarme.setTip(alarmeDTO.getTip());
        alarme.setData(alarmeDTO.getData());
        alarme.setPulsMinim(alarmeDTO.getPulsMinim());
        alarme.setPulsMaxim(alarmeDTO.getPulsMaxim());
        return Transformer.toDto(alarmeRepository.save(alarme));
    }
}
