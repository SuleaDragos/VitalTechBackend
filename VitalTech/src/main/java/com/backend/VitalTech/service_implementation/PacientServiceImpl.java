package com.backend.VitalTech.service_implementation;

import com.backend.VitalTech.Transformer;
import com.backend.VitalTech.entity.Pacient;
import com.backend.VitalTech.model.PacientDTO;
import com.backend.VitalTech.repository.MedicRepository;
import com.backend.VitalTech.repository.PacientRepository;
import com.backend.VitalTech.service.PacientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientServiceImpl  implements PacientService {
    private final PacientRepository pacientRepository;
    private final MedicRepository medicRepository;
    public List<PacientDTO> getPacienti()
    {
        return pacientRepository.findAll().stream().map(Transformer::toDto).toList();
    }
    public PacientDTO addPacient(PacientDTO pacientDTO)  // adaugarea asta e mai mare pentru ca trebuie referentiat medicul
    {
        var medic = medicRepository.findById(pacientDTO.getId_Medic());
        if(medic.isPresent()) {
            var pacient = new Pacient();
            pacient.setNume(pacientDTO.getNume());
            pacient.setPrenume(pacientDTO.getPrenume());
            pacient.setParola(pacientDTO.getParola());
            pacient.setVarsta(pacientDTO.getVarsta());
            pacient.setMedic(medic.get());
            return Transformer.toDto(pacientRepository.save(pacient));
        }
        return new PacientDTO();// am putea afisa altceva ca raspuns in loc de un obiect null
    }
    public PacientDTO getPacientById(Long id)
    {
        return Transformer.toDto(pacientRepository.getReferenceById(id));
    }
    public void deletePacient(Long id)
    {
        pacientRepository.deleteById(id);
    }
}
