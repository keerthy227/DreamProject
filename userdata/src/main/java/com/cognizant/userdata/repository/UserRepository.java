package com.cognizant.userdata.repository;

import com.cognizant.userdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    @Query(value = "select * from USER where role ='user'", nativeQuery = true)
    List<User> findAll();
}
