package org.regeneration.rest.restless.security;



<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/security/ApiUserDetailService.java
import org.regeneration.rest.restless.entity.User;
import org.regeneration.rest.restless.repository.UserRepository;
=======
import org.regeneration.efka.repository.UserRepository;
import org.regeneration.efka.entity.User;
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/security/ApiUserDetailService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApiUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // find user in repository
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }


        ApiUserDetails userDetails = new ApiUserDetails(user.getUsername(), user.getPassword());
        return userDetails;
    }
}
