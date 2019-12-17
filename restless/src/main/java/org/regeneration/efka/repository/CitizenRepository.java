package org.regeneration.efka.repository;


import org.regeneration.efka.entity.Appointment;
import org.regeneration.efka.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    Citizen findByAmka(Long amka);
    Citizen findById(int id);
    boolean existsByAmka(Long amka);
}
