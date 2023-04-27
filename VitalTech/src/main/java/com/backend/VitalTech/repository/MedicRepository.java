package com.backend.VitalTech.repository;

import com.backend.VitalTech.entity.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicRepository extends JpaRepository<Medic,Long> {
}
