package org.regeneration.sample.cervices;

import org.regeneration.sample.Entities.Citizen;
import org.regeneration.sample.Entities.User;
import org.regeneration.sample.reps.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Citizen getById(int id) {

        return new Citizen();
    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User saveOneCit(User user){

        userRepository.save(user);
        return  user;
    }
}
