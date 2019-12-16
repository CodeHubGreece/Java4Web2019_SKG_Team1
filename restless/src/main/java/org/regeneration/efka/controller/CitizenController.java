package org.regeneration.efka.controller;


import org.regeneration.efka.RegistrationData;
import org.regeneration.efka.entity.Citizen;
import org.regeneration.efka.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitizenController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping("/citizens")
    public List<Citizen> findAll() {
        return citizenService.findAll();
    }

    @PostMapping("/citizen/register")
    public Citizen registerCitizen(@RequestBody RegistrationData registrationData) {
        return citizenService.register(registrationData);
    }

}

