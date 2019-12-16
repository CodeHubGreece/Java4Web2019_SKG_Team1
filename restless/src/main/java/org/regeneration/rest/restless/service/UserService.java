package org.regeneration.rest.restless.service;

<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/service/UserService.java
import org.regeneration.rest.restless.entity.User;
import org.regeneration.rest.restless.repository.UserRepository;
=======
import org.regeneration.efka.repository.UserRepository;
import org.regeneration.efka.entity.User;
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/service/UserService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/service/UserService.java
=======
    public List<User> findAll(){
        return userRepository.findAll();
    }
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/service/UserService.java


    public User findById(int id) {
        return userRepository.findById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
