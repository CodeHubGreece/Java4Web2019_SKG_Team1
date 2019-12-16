package org.regeneration.rest.restless.repository;

import org.regeneration.rest.restless.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/repository/UserRepository.java
=======

    @Query
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/repository/UserRepository.java
    User findByUsername(String username);
    User findById(int id);
    List<User> findAllByUsernameAndType(String username, String type);
    boolean existsByUsername(String username);
}