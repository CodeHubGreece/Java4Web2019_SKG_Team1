package org.regeneration.sample.cervices;


import org.regeneration.sample.Entities.Citizen;
import org.regeneration.sample.Entities.User;
import org.regeneration.sample.Registration;
import org.regeneration.sample.reps.UserRepository;
import org.regeneration.sample.reps.CitizenRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    UserRepository userRepository;
    CitizenRepository citizenRepository;

    public RegistrationService(UserRepository userRepository, CitizenRepository citizenRepository) {
        this.userRepository = userRepository;
        this.citizenRepository = citizenRepository;
    }

    public Registration saveOneCit(Registration rp){

        User newUser = new User();
        Citizen newCitizen = new Citizen();

        newUser.setUsername(rp.getUsername());
        newUser.setPwd(rp.getPassword());

        newCitizen.setAmka(rp.getAmka());
        newCitizen.setFirstName(rp.getFirst_name());
        newCitizen.setLastName(rp.getLast_name());
        newCitizen.setEmail(rp.getEmail());
        newCitizen.setPhoneNumner(rp.getPhone_num());

        userRepository.save(newUser);
        citizenRepository.save(newCitizen);


        return  rp;
    }

}
