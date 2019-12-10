package org.regeneration.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.regeneration.sample.Entities.Specialty;
import org.regeneration.sample.repository.SpecialtyRepository;
import org.regeneration.sample.service.SpecialtyService;

import java.util.List;

@RestController
public class SpecialtyController {

    private final SpecialtyRepository specialtyRepository;
    private final SpecialtyService specialtyService;

    @Autowired
    public SpecialtyController(SpecialtyRepository specialtyRepository, SpecialtyService specialtyService) {
        this.specialtyRepository = specialtyRepository;
        this.specialtyService = specialtyService;
    }

    @GetMapping("/specialty/")
    public List<Specialty> getSpecialty() {
        return specialtyService.findAll();
    }

/*
    @GetMapping("/specialty/{specialty}")
    public Specialty getSpecialty(@PathVariable int specialtyId) {
        return specialtyService.findSpecialtyBySpecialty(specialtyId);
    }
*/
}
