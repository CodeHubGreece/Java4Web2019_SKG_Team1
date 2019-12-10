package org.regeneration.sample.Repositories;

import org.regeneration.sample.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
