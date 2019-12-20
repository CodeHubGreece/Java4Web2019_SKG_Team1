package org.regeneration.efka.controller;


import org.regeneration.efka.RegistrationData;
import org.regeneration.efka.entity.Citizen;
import org.regeneration.efka.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping("/citizens/register")
    public Citizen registerCitizen(@RequestBody RegistrationData registrationData) {
        return citizenService.register(registrationData);
    }

    @PostMapping("/citizens")
    public Citizen findByUserId(@RequestParam Integer id) {
        return citizenService.findByUserId(id);
    }

    @PostMapping("/users/checkAmka")
    public boolean checkAmka(@RequestParam String amka) {
        Long amkaLong;
        try {
            amkaLong = Long.valueOf(amka);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not parse AMKA");
        }
        return citizenService.checkAmka(amkaLong);
    }

}

