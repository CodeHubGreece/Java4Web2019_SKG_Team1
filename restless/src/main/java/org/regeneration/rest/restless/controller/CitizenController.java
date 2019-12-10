package org.regeneration.rest.restless.controller;


import lombok.Data;
import org.regeneration.rest.restless.Registration;
import org.regeneration.rest.restless.entity.Citizen;
import org.regeneration.rest.restless.repository.CitizenRepository;
import org.regeneration.rest.restless.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
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
	public Citizen registerCitizen(@RequestBody Registration registration){
		return citizenService.register(registration);
	}

}

