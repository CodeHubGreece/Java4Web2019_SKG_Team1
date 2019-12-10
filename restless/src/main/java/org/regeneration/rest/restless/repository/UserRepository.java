package org.regeneration.rest.restless.repository;

import org.regeneration.rest.restless.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findById(int id);
}