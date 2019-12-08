package com.regenetation.restless.controller;


import com.regenetation.restless.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.regenetation.restless.entity.Citizen;

import com.regenetation.restless.repository.CitizenRepository;

import java.util.List;

@RestController
public class CitizenController {

	private final CitizenRepository citizenRepository;
	private CitizenService citizenService;

	@Autowired
	public CitizenController(CitizenRepository citizenRepository, CitizenService citizenService) {
		this.citizenRepository = citizenRepository;
		this.citizenService = citizenService;
	}

	public CitizenController(CitizenRepository citizenRepository) {
		this.citizenRepository = citizenRepository;
	}

	@GetMapping("/citizen")
	public List<Citizen> getCitizen() { return citizenService.findAll(); }

	@GetMapping("/citizen/{id}") //done
	public Citizen getCitizen(@PathVariable int id) {
		return citizenService.getById(id);
	}

}

