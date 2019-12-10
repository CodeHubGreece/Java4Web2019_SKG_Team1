package org.regeneration.sample;

import org.regeneration.sample.Entities.Citizen;
import org.regeneration.sample.Entities.Doctor;
import org.regeneration.sample.Entities.Specialty;
import org.regeneration.sample.Entities.User;
import org.regeneration.sample.Repositories.CitizenRepository;
import org.regeneration.sample.Repositories.DoctorRepository;
import org.regeneration.sample.Repositories.SpecialtyRepository;
import org.regeneration.sample.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {

    private final DoctorRepository docRep;
    private final CitizenRepository citRep;
    private final SpecialtyRepository specRep;
    private final UserRepository userRep;

    @Autowired
    public SampleApplication(DoctorRepository docRep, CitizenRepository citRep, SpecialtyRepository specRep, UserRepository userRep) {
        this.docRep = docRep;
        this.citRep = citRep;
        this.specRep = specRep;
        this.userRep = userRep;
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("c", "hh", "password");
        userRep.save(user);

        Citizen cit = new Citizen(user,19955,"kalo","paidi","mail@e.com","Thong");
        citRep.save(cit);

        user.setCitizen(cit);

        userRep.save(user);



    }
}
