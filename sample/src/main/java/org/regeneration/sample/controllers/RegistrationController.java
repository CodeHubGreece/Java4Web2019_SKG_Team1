package org.regeneration.sample.controllers;

import org.regeneration.sample.Entities.Citizen;
import org.regeneration.sample.Registration;
import org.regeneration.sample.cervices.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

        RegistrationService registrationService;

        @Autowired
        public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/registration")
       public Registration createNewCitizen(@RequestBody Registration registratedPerson){
       return registrationService.saveOneCit(registratedPerson);
   }
}
