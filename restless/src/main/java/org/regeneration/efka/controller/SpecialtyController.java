package org.regeneration.efka.controller;

import org.regeneration.efka.entity.Specialty;
import org.regeneration.efka.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @Autowired
    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping("/specialties")
    public List<Specialty> findAll() {
        return specialtyService.findAll();
    }

/*
    @GetMapping("/specialty/{specialty}")
    public Specialty getSpecialty(@PathVariable int specialtyId) {
        return specialtyService.findSpecialtyBySpecialty(specialtyId);
    }
*/
}
