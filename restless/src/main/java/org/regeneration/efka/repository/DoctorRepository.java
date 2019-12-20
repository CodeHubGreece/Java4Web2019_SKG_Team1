package org.regeneration.efka.repository;

import org.regeneration.efka.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findById(int id);
    Doctor findByUserId(int id);
    List<Doctor> findAllBySpecialityId(int specialtyId);
}
