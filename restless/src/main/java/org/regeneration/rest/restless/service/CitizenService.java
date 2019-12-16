package org.regeneration.rest.restless.service;

<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/service/CitizenService.java
import org.regeneration.rest.restless.RegistrationData;
import org.regeneration.rest.restless.entity.Citizen;
import org.regeneration.rest.restless.entity.User;
import org.regeneration.rest.restless.repository.CitizenRepository;
import org.regeneration.rest.restless.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
=======
import org.regeneration.efka.repository.CitizenRepository;
import org.regeneration.efka.repository.UserRepository;
import org.regeneration.efka.RegistrationData;
import org.regeneration.efka.entity.Citizen;
import org.regeneration.efka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/service/CitizenService.java
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.NameAlreadyBoundException;
<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/service/CitizenService.java
=======
import java.util.InputMismatchException;
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/service/CitizenService.java
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
     //   if (userRepository.existsByUsername(registrationData.getUsername())) {
            User newUser = new User("c", registrationData.getUsername(), registrationData.getPassword());//passwordEncoder.encode(registrationData.getPassword()));
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
<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/service/CitizenService.java
=======
        } else {
            throw new InputMismatchException("User already exists!");
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/service/CitizenService.java
        }
     //   else{
        //  throw new NameAlreadyBoundException("Username already exists!");
    //   }
 //   }
}
