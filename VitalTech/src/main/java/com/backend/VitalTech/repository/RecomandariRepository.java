package com.backend.VitalTech.repository;

import com.backend.VitalTech.entity.Recomandari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomandariRepository extends JpaRepository<Recomandari,Long> {
}
