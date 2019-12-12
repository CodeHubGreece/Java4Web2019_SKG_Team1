package org.regeneration.rest.restless.controller;


import org.regeneration.rest.restless.RegistrationData;
import org.regeneration.rest.restless.entity.Citizen;
import org.regeneration.rest.restless.repository.CitizenRepository;
import org.regeneration.rest.restless.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameAlreadyBoundException;
import java.util.List;

@RestController
public class CitizenController {

	private final CitizenService citizenService;

	@Autowired
	public CitizenController(CitizenRepository citizenRepository, CitizenService citizenService) {
		this.citizenService = citizenService;
	}

	@GetMapping("/citizen")
	public List<Citizen> findAll() {
		return citizenService.findAll();
	}

	@GetMapping("/citizen/{amka}")
	public Citizen findByAmka(@PathVariable String amka) {
		return citizenService.findByAmka(Integer.parseInt(amka));
	}

	@PostMapping("/citizen/registration")
	public Citizen registerCitizen(@RequestBody RegistrationData registrationData){
		try {
			return citizenService.register(registrationData);
		} catch (NameAlreadyBoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}

