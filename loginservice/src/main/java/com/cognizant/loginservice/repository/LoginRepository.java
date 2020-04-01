package com.cognizant.loginservice.repository;

import com.cognizant.loginservice.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class LoginRepository implements CrudRepository<User, String> {

    public abstract Optional<User> findByUsername(String username);

}
