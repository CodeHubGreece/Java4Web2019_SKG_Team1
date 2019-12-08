package com.regenetation.restless.repository;

import com.regenetation.restless.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {


    Doctor getByUsername(String username);

    Doctor getById(int id);

    List<Doctor> findDoctorBySpecialty(int specialty);


    List<Doctor> findAll();
}
