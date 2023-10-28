package com.security.poc.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author by Danyal
 * @classname UserRepository
 * @Date 28/10/2023 12:38 am
 */
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
