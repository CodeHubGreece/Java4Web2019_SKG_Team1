package org.regeneration.sample.reps;

import org.regeneration.sample.Entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen,Long> {


    Citizen getById(Long id);

    @Override
     List<Citizen> findAll();

    @Override
     Citizen save(Citizen cit);
}
