package org.regeneration.efka.service;

import org.regeneration.efka.entity.Citizen;
import org.regeneration.efka.entity.User;
import org.regeneration.efka.repository.UserRepository;
import org.regeneration.efka.RegistrationData;
import org.regeneration.efka.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.InputMismatchException;
import java.util.List;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.citizenRepository = citizenRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Citizen findById(int id) {
        return citizenRepository.findById(id);
    }

    public Citizen findByAmka(Long amka) {
        return citizenRepository.findByAmka(amka);
    }

    public List<Citizen> findAll() {
        return citizenRepository.findAll();
    }

    public boolean checkAmka(Long amka) {
        return citizenRepository.existsByAmka(amka);
    }

    public Citizen register(RegistrationData registrationData) throws InputMismatchException {

        if (!userRepository.existsByUsername(registrationData.getUsername())
                && !citizenRepository.existsByAmka(registrationData.getAmka())) {

            User newUser = new User("c", registrationData.getUsername(), passwordEncoder.encode(registrationData.getPassword()));
            Citizen newCitizen = new Citizen(
                    registrationData.getAmka(),
                    registrationData.getFirst_name(),
                    registrationData.getLast_name(),
                    registrationData.getEmail(),
                    registrationData.getPhone_num());

            newUser.setCitizen(newCitizen);
            newCitizen.setUser(newUser);

            userRepository.save(newUser);

            return citizenRepository.findById(newCitizen.getId());
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"User already exists");
        }
    }
}
