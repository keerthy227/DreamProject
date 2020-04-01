package com.cognizant.loginservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameNotFound extends BadCredentialsException {

    public UsernameNotFound(String message) {
        super(message);
        log.info("inside UsernameNotFound class");
    }
}



