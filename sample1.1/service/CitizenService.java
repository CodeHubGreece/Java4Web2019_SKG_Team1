package org.regeneration.sample.service;

import org.regeneration.sample.Entities.Citizen;
import org.regeneration.sample.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;
    private CitizenService citizenService;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }


    public Citizen findById(int id) {
        return new Citizen();
    }
    public Citizen findByAmka(int amka) {
        return new Citizen();
    }

    public List<Citizen> findAll() {
        return citizenService.findAll();
    }
}
