package org.regeneration.rest.restless.repository;

import org.regeneration.rest.restless.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findById(int id);
    List<Doctor> findAllBySpecialityId(int specialtyId);
    List<Doctor> findAll();
}
