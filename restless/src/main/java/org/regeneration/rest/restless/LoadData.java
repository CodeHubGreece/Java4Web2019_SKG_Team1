package org.regeneration.rest.restless;

import org.regeneration.rest.restless.entity.User;
import org.regeneration.rest.restless.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoadData {
/*
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User(,"user", passwordEncoder.encode("user"));
            User moderator = new User("moderator", passwordEncoder.encode("moderator"));
            User admin = new User("admin", passwordEncoder.encode("admin"));
            userRepository.save(user);
            userRepository.save(moderator);
            userRepository.save(admin);
        };

    }*/
}
