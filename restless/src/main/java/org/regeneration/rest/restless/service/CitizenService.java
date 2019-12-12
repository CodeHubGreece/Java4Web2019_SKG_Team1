package org.regeneration.rest.restless.service;

import org.regeneration.rest.restless.RegistrationData;
import org.regeneration.rest.restless.entity.Citizen;
import org.regeneration.rest.restless.entity.User;
import org.regeneration.rest.restless.repository.CitizenRepository;
import org.regeneration.rest.restless.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.NameAlreadyBoundException;
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

    public Citizen findByAmka(int amka) {
        return citizenRepository.findByAmka(amka);
    }

    public List<Citizen> findAll() {
        return citizenRepository.findAll();
    }

    public Citizen register(RegistrationData registrationData) throws NameAlreadyBoundException {
        if (userRepository.existsByUsername(registrationData.getUsername())) {
            User newUser = new User("c", registrationData.getUsername(), passwordEncoder.encode(registrationData.getPassword()));
            Citizen newCitizen = new Citizen(
                    registrationData.getAmka(),
                    registrationData.getFirst_name(),
                    registrationData.getLast_name(),
                    registrationData.getEmail(),
                    registrationData.getPhone_num()
            );

            newUser.setCitizen(newCitizen);
            newCitizen.setUser(newUser);

            userRepository.save(newUser);

            return citizenRepository.findById(newCitizen.getId());
        }else{
            throw new NameAlreadyBoundException("Username already exists!");
        }
    }
}
