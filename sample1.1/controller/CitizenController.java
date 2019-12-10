package org.regeneration.sample.controller;


import org.regeneration.sample.Entities.Citizen;
import org.regeneration.sample.repository.CitizenRepository;
import org.regeneration.sample.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitizenController {

	private final CitizenRepository citizenRepository;
	private final CitizenService citizenService;


	@Autowired
	public CitizenController(CitizenRepository citizenRepository, CitizenService citizenService) {
		this.citizenRepository = citizenRepository;
		this.citizenService = citizenService;
	}

	@GetMapping("/citizen")
	public List<Citizen> getCitizen() {
		return citizenService.findAll();
	}

	@GetMapping("/citizen/{amka}")
	public Citizen getCitizen(@PathVariable int amka) {
		return citizenService.findByAmka(amka);
	}

}

