package org.regeneration.efka.controller;

import org.regeneration.efka.entity.User;
import org.regeneration.efka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/users")
    public User findByUsername(@RequestParam String username,Principal loggedInUser){
        return userService.findByUsername(username);
    }

    @PostMapping("/users/checkUsername")
    public boolean checkUsername(@RequestParam String username){
        return userService.checkUsername(username);
    }
}
