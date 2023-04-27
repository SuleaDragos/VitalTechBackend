package com.backend.VitalTech.repository;

import com.backend.VitalTech.entity.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientRepository extends JpaRepository<Pacient,Long> {
}
