package com.backend.VitalTech.repository;

import com.backend.VitalTech.entity.Alarme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmeRepository extends JpaRepository<Alarme,Long> {
}
