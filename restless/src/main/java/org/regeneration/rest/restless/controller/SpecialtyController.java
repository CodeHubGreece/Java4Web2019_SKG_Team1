package org.regeneration.rest.restless.controller;

import org.regeneration.rest.restless.entity.Specialty;
import org.regeneration.rest.restless.repository.SpecialtyRepository;
import org.regeneration.rest.restless.service.SpecialtyService;
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
