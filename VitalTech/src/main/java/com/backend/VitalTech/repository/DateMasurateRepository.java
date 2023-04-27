package com.backend.VitalTech.repository;

import com.backend.VitalTech.entity.DateMasurate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateMasurateRepository extends JpaRepository<DateMasurate,Long> {

}
