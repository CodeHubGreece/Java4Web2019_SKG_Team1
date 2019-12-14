package org.regeneration.efka.repository;


import org.regeneration.efka.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    Citizen findByAmka(int amka);
    Citizen findById(int id);
    boolean existsByAmka(int amka);
}
