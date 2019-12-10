package org.regeneration.sample.controller;

import org.regeneration.sample.repository.DoctorRepository;
import org.regeneration.sample.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.regeneration.sample.Entities.Doctor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    private final DoctorService doctorService;
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository, DoctorService doctorService) {
        this.doctorRepository = doctorRepository;
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor")
    public List<Doctor> getDoctor() {
        return doctorService.findAll();
    }

    @GetMapping("/doctor/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorService.findDoctorById(id);
    }

    @GetMapping("/doc/{specialty}")
    public List<Doctor> getDoctor(@PathVariable int specialtyId){
        return doctorService.findDoctorBySpecialty(specialtyId);
    }

}

