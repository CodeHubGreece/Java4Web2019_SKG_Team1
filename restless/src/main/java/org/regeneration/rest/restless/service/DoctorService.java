package org.regeneration.rest.restless.service;


<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/service/DoctorService.java
import org.regeneration.rest.restless.entity.Doctor;
import org.regeneration.rest.restless.repository.DoctorRepository;
=======
import org.regeneration.efka.repository.DoctorRepository;
import org.regeneration.efka.entity.Doctor;
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/service/DoctorService.java
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
