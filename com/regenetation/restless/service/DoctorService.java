package com.regenetation.restless.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.regenetation.restless.entity.Doctor;
import com.regenetation.restless.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }



    public Doctor getDoctorById(int id){
        return doctorRepository.getById(id);
    }

    public List<Doctor> getDoctorBySpecialty(int specialty){
        return doctorRepository.findDoctorBySpecialty(specialty);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
