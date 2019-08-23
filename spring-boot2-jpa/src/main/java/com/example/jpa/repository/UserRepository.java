package com.example.jpa.repository;


import com.example.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByName(String name);

}
