package org.regeneration.rest.restless.repository;


import org.regeneration.rest.restless.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    Citizen findByAmka(int amka);
    Citizen findById(int id);
    List<Citizen> findAll();
}
