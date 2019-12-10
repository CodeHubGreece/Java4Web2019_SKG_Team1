package org.regeneration.sample.Repositories;

import org.regeneration.sample.Entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
}