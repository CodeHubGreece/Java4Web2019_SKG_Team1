package org.regeneration.efka.repository;

import org.regeneration.efka.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer>{
    Specialty findById(int specialtyId);
}
