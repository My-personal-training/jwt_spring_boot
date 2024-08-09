package com.courses.jwt.jwtcourse.repositories;

import com.courses.jwt.jwtcourse.models.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
   Optional<User> findByEmail(String email);
}