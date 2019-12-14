package org.regeneration.efka.service;

import org.regeneration.efka.repository.SpecialtyRepository;
import org.regeneration.efka.entity.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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


    public Specialty findById(int specialtyId){
        return specialtyRepository.findById(specialtyId);
    }

}
