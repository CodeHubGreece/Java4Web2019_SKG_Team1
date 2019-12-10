package org.regeneration.rest.restless.controller;

import org.regeneration.rest.restless.entity.User;
import org.regeneration.rest.restless.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }


    @GetMapping("/user/{id}")
    public User findByAmka(@PathVariable String id) {
        return userService.findById(Integer.parseInt(id));
    }
}
