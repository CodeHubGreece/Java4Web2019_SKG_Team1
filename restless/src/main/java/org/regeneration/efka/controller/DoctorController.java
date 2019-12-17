package org.regeneration.efka.controller;

import org.regeneration.efka.entity.Doctor;
import org.regeneration.efka.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public List<Doctor> findAllBySpecialityId(@RequestParam(name = "specialtyId") Integer specialtyId) {
        return doctorService.findAllBySpecialityId(specialtyId);
    }
}

