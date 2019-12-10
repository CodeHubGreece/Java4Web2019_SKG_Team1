package org.regeneration.sample.repository;

import org.regeneration.sample.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {



    Doctor findById(int id);

    List<Doctor> findDoctorBySpecialty(int specialty);


}
