package org.regeneration.sample.security;

import org.regeneration.sample.repository.UserRepository;
import org.regeneration.sample.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ApiUserDetailService implements UserDetailsService{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("usern");
        }
        ApiUserDetails userDetails = new ApiUserDetails(user.getUsername(),  user.getPwd());
        return userDetails;
    }


}
