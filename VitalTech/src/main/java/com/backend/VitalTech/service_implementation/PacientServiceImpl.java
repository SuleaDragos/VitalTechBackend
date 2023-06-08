package com.backend.VitalTech.service_implementation;

import com.backend.VitalTech.Transformer;
import com.backend.VitalTech.UpdatableBCrypt;
import com.backend.VitalTech.entity.Pacient;
import com.backend.VitalTech.model.PacientDTO;
import com.backend.VitalTech.repository.*;
import com.backend.VitalTech.service.DateMasurateService;
import com.backend.VitalTech.service.PacientService;
import com.backend.VitalTech.service.RecomandariService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class PacientServiceImpl  implements PacientService {
    private final PacientRepository pacientRepository;
    private final MedicRepository medicRepository;
    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(11);
    String[] mutableHash = new String[1];
    Function<String, Boolean> update = hash -> { mutableHash[0] = hash; return true; };

    public static String hash(String password) {
        return bcrypt.hash(password);
    }

    public static boolean verifyAndUpdateHash(String password, String hash, Function<String, Boolean> updateFunc) {
        return bcrypt.verifyAndUpdateHash(password, hash, updateFunc);
    }

    public List<PacientDTO> getPacienti()
    {
        return pacientRepository.findAll().stream().map(Transformer::toDto).toList();
    }
    public List<PacientDTO> getPacientiByMeidcId(Long id){
        return pacientRepository.findAllByMedicId(id).stream().map(Transformer::toDto).toList();
    }
    public PacientDTO addPacient(PacientDTO pacientDTO)  // adaugarea asta e mai mare pentru ca trebuie referentiat medicul
    {
        var medic = medicRepository.findById(pacientDTO.getId_Medic());
        if(medic.isPresent()) {
            var pacient = new Pacient();
            pacient.setNume(pacientDTO.getNume());
            pacient.setPrenume(pacientDTO.getPrenume());
            pacient.setParola(hash(pacientDTO.getParola()));
            pacient.setVarsta(pacientDTO.getVarsta());
            pacient.setCnp(pacientDTO.getCnp());
            pacient.setAdresa(pacientDTO.getAdresa());
            pacient.setNumarTelefon(pacientDTO.getNumarTelefon());
            pacient.setAdresaMail(pacientDTO.getAdresaMail());
            pacient.setProfesie(pacientDTO.getProfesie());
            pacient.setLocDeMunca(pacientDTO.getLocDeMunca());
            pacient.setIstoricMedical(pacientDTO.getIstoricMedical());
            pacient.setAlergii(pacientDTO.getAlergii());
            pacient.setConsultatiCardiologice(pacientDTO.getConsultatiiCardiologice());
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
    public Long getPacientIdByEmail(String mail, String password){
        var pacient = pacientRepository.findTopByAdresaMail(mail);
        if(verifyAndUpdateHash(password,pacient.get().getParola(),update))
            return pacient.get().getId();
        else
            return 0L;
    }
    public PacientDTO updatePacient(Long id, PacientDTO pacientDTO) {
        var pacientData = pacientRepository.findById(id);
        Pacient pacient = pacientData.get();
        pacient.setNume(pacientDTO.getNume());
        pacient.setPrenume(pacientDTO.getPrenume());
        pacient.setParola(pacientDTO.getParola());
        pacient.setVarsta(pacientDTO.getVarsta());
        pacient.setCnp(pacientDTO.getCnp());
        pacient.setAdresa(pacientDTO.getAdresa());
        pacient.setNumarTelefon(pacientDTO.getNumarTelefon());
        pacient.setAdresaMail(pacientDTO.getAdresaMail());
        pacient.setProfesie(pacientDTO.getProfesie());
        pacient.setLocDeMunca(pacientDTO.getLocDeMunca());
        pacient.setIstoricMedical(pacientDTO.getIstoricMedical());
        pacient.setAlergii(pacientDTO.getAlergii());
        pacient.setConsultatiCardiologice(pacientDTO.getConsultatiiCardiologice());

        return Transformer.toDto(pacientRepository.save(pacient));
    }

}
