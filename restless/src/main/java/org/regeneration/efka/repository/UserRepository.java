package org.regeneration.efka.repository;

import org.regeneration.efka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User findById(int id);
    List<User> findAllByUsernameAndType(String username, String type);
    boolean existsByUsername(String username);
}