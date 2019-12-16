package org.regeneration.rest.restless;

import org.regeneration.efka.entity.Citizen;
import org.regeneration.efka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RestlessApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestlessApplication.class, args);


	}

}
