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
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor findById(int id) {
        Doctor doc =doctorRepository.findByUserId(id);
        return doc;
    }

    public List<Doctor> findAllBySpecialityId(Integer specialtyId) {
        if (specialtyId != null) {
            return doctorRepository.findAllBySpecialityId(specialtyId);
        } else {
            return doctorRepository.findAll();
        }
    }
}
