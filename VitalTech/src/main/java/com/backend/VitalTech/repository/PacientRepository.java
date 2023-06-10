package com.backend.VitalTech.repository;


import com.backend.VitalTech.entity.Medic;
import com.backend.VitalTech.entity.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PacientRepository extends JpaRepository<Pacient,Long> {
    List<Pacient> findAllByMedicId(Long medicId);
    Pacient findTopByAdresaMail(String mailMedic);
    Pacient findByAdresaMail(String mailMedic);
}
