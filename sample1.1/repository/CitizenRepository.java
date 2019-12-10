package org.regeneration.sample.repository;

import org.regeneration.sample.Entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {




    Citizen findByAmka(int amka);
    Citizen findById(int id);

    @Override
    List<Citizen> findAll();



}
