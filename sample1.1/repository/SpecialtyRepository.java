package org.regeneration.sample.repository;

import org.regeneration.sample.Entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SpecialtyRepository extends JpaRepository<Specialty, Integer>{

    Specialty findBySpecialty(int specialty);

}
