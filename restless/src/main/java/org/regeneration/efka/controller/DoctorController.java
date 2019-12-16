package org.regeneration.efka.controller;

import org.regeneration.efka.entity.Doctor;
import org.regeneration.efka.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("/doctor")
    public List<Doctor> findAllBySpecialityId(@RequestParam(name = "specialtyId") int specialtyId) {
        return doctorService.findAllBySpecialityId(specialtyId);
    }
}

