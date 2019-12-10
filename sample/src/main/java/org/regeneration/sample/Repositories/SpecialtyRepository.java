package org.regeneration.sample.Repositories;

import org.regeneration.sample.Entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty,Integer> {
}
