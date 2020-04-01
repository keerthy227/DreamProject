package com.cognizant.userdata.service;

import com.cognizant.userdata.Exception.UsernameNotFoundException;
import com.cognizant.userdata.model.User;
import com.cognizant.userdata.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class DataService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> getUser(String username) throws UsernameNotFoundException {
        log.info(username);
        if (userRepository.findByUsername(username).isPresent()) {
            Optional<User> user = userRepository.findByUsername(username);
            return user;
        } else {
            log.info("Username not found");
            throw new UsernameNotFoundException("Username is incorrect");

        }
    }

    public void register(User user) {
        log.info("Inside register");
        userRepository.save(user);
    }



}

