package org.regeneration.rest.restless.service;

import org.regeneration.rest.restless.Registration;
import org.regeneration.rest.restless.entity.Citizen;
import org.regeneration.rest.restless.entity.User;
import org.regeneration.rest.restless.repository.CitizenRepository;
import org.regeneration.rest.restless.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;
    private final UserRepository userRepository;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository, UserRepository userRepository) {
        this.citizenRepository = citizenRepository;
        this.userRepository = userRepository;
    }


    public Citizen findById(int id) {
        return citizenRepository.findById(id);
    }

    public Citizen findByAmka(int amka) {
        return citizenRepository.findByAmka(amka);
    }

    public List<Citizen> findAll() {
        return citizenRepository.findAll();
    }


    public Citizen register(Registration registration) {
        User newUser = new User("c", registration.getUsername(), registration.getPassword());
        Citizen newCitizen = new Citizen(
                newUser,
                registration.getAmka(),
                registration.getFirst_name(),
                registration.getLast_name(),
                registration.getEmail(),
                registration.getPhone_num()
        );


        userRepository.save(newUser);
        citizenRepository.save(newCitizen);
        newUser.setCitizen(newCitizen);
        System.out.println(userRepository.findById(newUser.getId()).getCitizen());
        System.out.println(citizenRepository.findById(newCitizen.getId()).getUser());
        return citizenRepository.findById(newCitizen.getId());
    }
}
