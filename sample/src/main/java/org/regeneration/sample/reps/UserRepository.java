package org.regeneration.sample.reps;

import org.regeneration.sample.Entities.Citizen;
import org.regeneration.sample.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User getById(Long id);

    @Override
    List<User> findAll();

    @Override
    User save(User user);


}
