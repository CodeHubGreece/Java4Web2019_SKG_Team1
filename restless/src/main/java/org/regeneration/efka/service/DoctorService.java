package org.regeneration.efka.service;


import org.regeneration.efka.entity.Doctor;
import org.regeneration.efka.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public Doctor findById(int id){
        return doctorRepository.findById(id);
    }

    public List<Doctor> findAllBySpecialityId(int specialtyId){
        return doctorRepository.findAllBySpecialityId(specialtyId);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
