package com.backend.VitalTech.service_implementation;

import com.backend.VitalTech.Transformer;
import com.backend.VitalTech.UpdatableBCrypt;
import com.backend.VitalTech.entity.Pacient;
import com.backend.VitalTech.model.MedicDTO;
import com.backend.VitalTech.repository.MedicRepository;
import com.backend.VitalTech.repository.PacientRepository;
import com.backend.VitalTech.service.MedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class MedicServiceImpl implements MedicService {
    private final MedicRepository medicRepository;
    private final PacientRepository pacientRepository;

    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(11);
    String[] mutableHash = new String[1];
    Function<String, Boolean> update = hash -> { mutableHash[0] = hash; return true; };

    public static String hash(String password) {
        return bcrypt.hash(password);
    }

    public static boolean verifyAndUpdateHash(String password, String hash, Function<String, Boolean> updateFunc) {
        return bcrypt.verifyAndUpdateHash(password, hash, updateFunc);
    }
    public List<MedicDTO> getMedici()
    {
        return medicRepository.findAll().stream().map(Transformer::toDto).toList();
    }
    public MedicDTO addMedic(MedicDTO medicDTO)
    {
        medicDTO.setParola(hash(medicDTO.getParola()));
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
    public Long getMedicIdByEmail(String mail, String password){
        var medic = medicRepository.findTopByAdresaMail(mail);
        if(verifyAndUpdateHash(password,medic.get().getParola(),update))
            return medic.get().getId();
        else
            return -1L;
    }
    public MedicDTO getMedicByEmail(String mail, String password){

        var medic = medicRepository.findTopByAdresaMail(mail);
        if(verifyAndUpdateHash(password,medic.get().getParola(),update))
            return Transformer.toDto(medicRepository.findByAdresaMail(mail));
        else
            throw new NoSuchElementException();
    }
}
