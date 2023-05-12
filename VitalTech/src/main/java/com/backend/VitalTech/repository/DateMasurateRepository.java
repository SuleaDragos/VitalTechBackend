package com.backend.VitalTech.repository;

import com.backend.VitalTech.entity.DateMasurate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateMasurateRepository extends JpaRepository<DateMasurate,Long> {
    List<DateMasurate> findAllByPacientId(Long pacientId);
}
