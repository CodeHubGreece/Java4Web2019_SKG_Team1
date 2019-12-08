package com.regenetation.restless.service;

import com.regenetation.restless.entity.Citizen;
import com.regenetation.restless.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public Citizen getById(int id) {

        return new Citizen();
    }

    public List<Citizen> findAll() {

        return citizenRepository.findAll();
    }

}
