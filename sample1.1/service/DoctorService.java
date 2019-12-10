package org.regeneration.sample.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.regeneration.sample.Entities.Doctor;
import org.regeneration.sample.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }



    public Doctor findDoctorById(int id){
        return doctorRepository.findById(id);
    }

    public List<Doctor> findDoctorBySpecialty(int specialtyId){
        return doctorRepository.findDoctorBySpecialty(specialtyId);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
