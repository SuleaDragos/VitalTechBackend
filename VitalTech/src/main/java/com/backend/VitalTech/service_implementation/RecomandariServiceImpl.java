package com.backend.VitalTech.service_implementation;

import com.backend.VitalTech.Transformer;
import com.backend.VitalTech.entity.Recomandari;
import com.backend.VitalTech.model.RecomandariDTO;
import com.backend.VitalTech.repository.RecomandariRepository;
import com.backend.VitalTech.repository.PacientRepository;
import com.backend.VitalTech.service.RecomandariService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecomandariServiceImpl implements RecomandariService {
    private final RecomandariRepository recomandariRepository;
    private final PacientRepository pacientRepository;
    public List<RecomandariDTO> getRecomandarile()
    {
        return recomandariRepository.findAll().stream().map(Transformer::toDto).toList();
    }
    public List<RecomandariDTO> getRecomandarileByPacientId(Long id){
        return recomandariRepository.findAllByPacientId(id).stream().map(Transformer::toDto).toList();
    }
    public RecomandariDTO addRecomandari(RecomandariDTO recomandariDTO)  // adaugarea asta e mai mare pentru ca trebuie referentiat pacientul
    {
        var pacient = pacientRepository.findById(recomandariDTO.getId_Pacient());
        if(pacient.isPresent()) {
            var recomandari = new Recomandari();
            recomandari.setRecomandare(recomandariDTO.getRecomandare());
            recomandari.setDurataZilnica(recomandariDTO.getDurataZilnica());
            recomandari.setAlteIndicatii(recomandariDTO.getAlteIndicatii());
            recomandari.setPacient(pacient.get());
            return Transformer.toDto(recomandariRepository.save(recomandari));
        }
        return new RecomandariDTO();
    }
    public RecomandariDTO getRecomandariById(Long id)
    {
        return Transformer.toDto(recomandariRepository.getReferenceById(id));
    }
    public void deleteRecomandari(Long id)
    {
        recomandariRepository.deleteById(id);
    }
}
