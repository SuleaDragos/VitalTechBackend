package com.backend.VitalTech.service_implementation;

import com.backend.VitalTech.Transformer;
import com.backend.VitalTech.model.MedicDTO;
import com.backend.VitalTech.repository.MedicRepository;
import com.backend.VitalTech.service.MedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicServiceImpl implements MedicService {
    private final MedicRepository medicRepository;
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
}