package com.cognizant.userdata.controller;

import com.cognizant.userdata.Exception.UserAlreadyExistsException;
import com.cognizant.userdata.model.User;
import com.cognizant.userdata.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    DataService dataService;

    @GetMapping("/{username}")
    public Optional<User> data(@PathVariable String username) throws UsernameNotFoundException {
        log.info("Reached from 1112");
        log.info(username);
        return dataService.getUser(username);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid User user) throws UserAlreadyExistsException {
        dataService.register(user);

    }


}
