package com.backend.VitalTech.service_implementation;

import com.backend.VitalTech.Transformer;
import com.backend.VitalTech.entity.Pacient;
import com.backend.VitalTech.model.MedicDTO;
import com.backend.VitalTech.repository.MedicRepository;
import com.backend.VitalTech.repository.PacientRepository;
import com.backend.VitalTech.service.MedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicServiceImpl implements MedicService {
    private final MedicRepository medicRepository;
    private final PacientRepository pacientRepository;
    public List<MedicDTO> getMedici()
    {
        return medicRepository.findAll().stream().map(Transformer::toDto).toList();
    }
    public MedicDTO addMedic(MedicDTO medicDTO)
    {
        return Transformer.toDto(medicRepository.save(Transformer.fromDto(medicDTO)));
    }
    public MedicDTO getMedicById(Long id)
    {
        return Transformer.toDto(medicRepository.getReferenceById(id));
    }
    public void deleteMedic(Long id)
    {
        medicRepository.deleteById(id);
    }
    public Long getMedicIdByEmail(String mail){
        var medic = medicRepository.findTopByAdresaMail(mail);
        return medic.get().getId();
    }
}
