package org.regeneration.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.regeneration.sample.Entities.Specialty;
import org.regeneration.sample.repository.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyService(SpecialtyRepository specialtyRepository){
        this.specialtyRepository = specialtyRepository;
    }


    public List<Specialty> findAll(){
        return specialtyRepository.findAll();
    }


    public Specialty findSpecialtyBySpecialty(int specialty){
        return specialtyRepository.findBySpecialty(specialty);
    }

}
