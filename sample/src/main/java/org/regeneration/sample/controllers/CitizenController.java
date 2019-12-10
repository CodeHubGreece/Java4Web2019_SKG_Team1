package org.regeneration.sample.controllers;


import org.regeneration.sample.Entities.Citizen;
import org.regeneration.sample.cervices.CitizenService;

import org.regeneration.sample.reps.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitizenController {

    private CitizenRepository citizenRepository;
    private CitizenService citizenService;




    @Autowired
    public CitizenController(CitizenRepository citizenRepository, CitizenService citizenService) {
        this.citizenRepository = citizenRepository;
        this.citizenService = citizenService;
    }

    public CitizenController(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @GetMapping("/citizen")
    public List<Citizen> getCitizen() { return citizenService.findAll(); }

    @GetMapping("/citizen/{id}") //done
    public Citizen getCitizen(@PathVariable int id) {
        return citizenService.getById(id);
    }
//
//    @PostMapping("/registration")
//    public Citizen createNewCitizen(@RequestBody Citizen citizen){
//        return citizenService.saveOneCit(citizen);
//    }


}

