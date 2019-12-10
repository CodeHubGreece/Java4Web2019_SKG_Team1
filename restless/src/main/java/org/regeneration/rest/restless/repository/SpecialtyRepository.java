package org.regeneration.rest.restless.repository;

import org.regeneration.rest.restless.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer>{
    Specialty findById(int specialtyId);
    List<Specialty> findAll();
}
