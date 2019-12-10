package org.regeneration.rest.restless.controller;

import org.regeneration.rest.restless.entity.Doctor;
import org.regeneration.rest.restless.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor")
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("/doctor/{id}")
    public Doctor findById(@PathVariable String id){
        return doctorService.findById(Integer.parseInt(id));
    }

    @GetMapping("/doctor/{specialty}")
    public List<Doctor> findAllBySpecialityId(@PathVariable int specialtyId, @PathVariable String specialty){
        return doctorService.findAllBySpecialityId(specialtyId);
    }

}

