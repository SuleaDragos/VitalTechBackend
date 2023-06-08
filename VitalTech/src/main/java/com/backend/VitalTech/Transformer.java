package com.backend.VitalTech;

import com.backend.VitalTech.entity.*;
import com.backend.VitalTech.model.*;

public class Transformer {
    public static MedicDTO toDto(Medic entity){
        var dto = new MedicDTO();
        dto.setId(entity.getId());
        dto.setNume(entity.getNume());
        dto.setPrenume(entity.getPrenume());
        dto.setParola(entity.getParola());
        dto.setAdresaMail(entity.getAdresaMail());
        return dto;
    }
    public static Medic fromDto(MedicDTO dto){
        var entity = new Medic();
        entity.setNume(dto.getNume());
        entity.setPrenume(dto.getPrenume());
        entity.setParola(dto.getParola());
        entity.setAdresaMail(dto.getAdresaMail());
        return entity;
    }
    public static PacientDTO toDto(Pacient entity){
        var dto = new PacientDTO();
        dto.setId(entity.getId());
        dto.setNume(entity.getNume());
        dto.setPrenume(entity.getPrenume());
        dto.setParola(entity.getParola());
        dto.setVarsta(entity.getVarsta());
        dto.setCnp(entity.getCnp());
        dto.setAdresa(entity.getAdresa());
        dto.setNumarTelefon(entity.getNumarTelefon());
        dto.setAdresaMail(entity.getAdresaMail());
        dto.setProfesie(entity.getProfesie());
        dto.setLocDeMunca(entity.getLocDeMunca());
        dto.setIstoricMedical(entity.getIstoricMedical());
        dto.setAlergii(entity.getAlergii());
        dto.setConsultatiiCardiologice(entity.getConsultatiCardiologice());
        dto.setId_Medic(entity.getMedic().getId()); //Trebuie Comentata in cazul in care nu referentiem medici la pacient
        return dto;
    }
    public static Pacient fromDto(PacientDTO dto){
        var entity = new Pacient();
        entity.setNume(dto.getNume());
        entity.setPrenume(dto.getPrenume());
        entity.setParola(dto.getParola());
        entity.setVarsta(dto.getVarsta());
        entity.setCnp(dto.getCnp());
        entity.setAdresa(dto.getAdresa());
        entity.setNumarTelefon(dto.getNumarTelefon());
        entity.setAdresaMail(dto.getAdresaMail());
        entity.setProfesie(dto.getProfesie());
        entity.setLocDeMunca(dto.getLocDeMunca());
        entity.setIstoricMedical(dto.getIstoricMedical());
        entity.setAlergii(dto.getAlergii());
        entity.setConsultatiCardiologice(dto.getConsultatiiCardiologice());
        return entity;
    }
    public static AlarmeDTO toDto(Alarme entity){
        var dto = new AlarmeDTO();
        dto.setId(entity.getId());
        dto.setTip(entity.getTip());
        dto.setPulsMinim(entity.getPulsMinim());
        dto.setPulsMaxim(entity.getPulsMaxim());
        dto.setData(entity.getData());
        dto.setId_Pacient(entity.getPacient().getId());
        return dto;
    }
    public static Alarme fromDto(AlarmeDTO dto){
        var entity = new Alarme();
        entity.setTip(dto.getTip());
        entity.setPulsMinim(dto.getPulsMinim());
        entity.setPulsMaxim(dto.getPulsMaxim());
        entity.setData(dto.getData());
        return entity;
    }
    public static DateMasurateDTO toDto(DateMasurate entity){
        var dto = new DateMasurateDTO();
        dto.setId(entity.getId());
        dto.setTip(entity.getTip());
        dto.setValoare(entity.getValoare());
        dto.setId_Pacient(entity.getPacient().getId());
        return dto;
    }
    public static DateMasurate fromDto(DateMasurateDTO dto){
        var entity = new DateMasurate();
        entity.setTip(dto.getTip());
        entity.setValoare(dto.getValoare());
        return entity;
    }
    public static RecomandariDTO toDto(Recomandari entity){
        var dto = new RecomandariDTO();
        dto.setId(entity.getId());
        dto.setRecomandare(entity.getRecomandare());
        dto.setDurataZilnica(entity.getDurataZilnica());
        dto.setAlteIndicatii(entity.getAlteIndicatii());
        dto.setId_Pacient(entity.getPacient().getId());
        return dto;
    }
    public static Recomandari fromDto(RecomandariDTO dto){
        var entity = new Recomandari();
        entity.setRecomandare(dto.getRecomandare());
        entity.setDurataZilnica(dto.getDurataZilnica());
        entity.setAlteIndicatii(dto.getAlteIndicatii());
        return entity;
    }
}
