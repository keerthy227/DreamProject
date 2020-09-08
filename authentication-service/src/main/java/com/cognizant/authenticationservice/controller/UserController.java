package com.cognizant.authenticationservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.security.AppUserDetailsService;
import com.cognizant.dreams.entity.jpa.User;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	AppUserDetailsService appUserDetailsService;

	
	
	@PostMapping
	public void signup(@RequestBody @Valid User newUser) throws UserAlreadyExistsException {
		
		appUserDetailsService.signup(newUser);
		
	}


}
