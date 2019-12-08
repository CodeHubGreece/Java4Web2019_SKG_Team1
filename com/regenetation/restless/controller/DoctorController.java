package com.regenetation.restless.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.regenetation.restless.entity.Doctor;
import com.regenetation.restless.repository.DoctorRepository;
import com.regenetation.restless.service.DoctorService;

import java.util.List;

@RestController
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository, DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor")
    public List<Doctor> getDoctor() {
        return doctorService.findAll();
    }

    @GetMapping("/doc/{specialty}")
    public List<Doctor> getDoctorBySpecialty(@PathVariable int specialtyId){
        return doctorService.getDoctorBySpecialty(specialtyId);
    }

}

