package com.regenetation.restless.repository;

import com.regenetation.restless.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {


    Citizen getByUsername(String username);

    Citizen getById(int id);

    List<Citizen> findAll();


}
