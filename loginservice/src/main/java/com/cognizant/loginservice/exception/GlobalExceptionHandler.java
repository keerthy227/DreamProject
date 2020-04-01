package com.cognizant.loginservice.exception;

import java.io.IOException;
import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameNotFound.class)
    public ResponseEntity<ErrorMessage> userHandler(UsernameNotFound ex, WebRequest request) throws IOException {
        log.info("inside exception-global exception handler");
        ErrorMessage error=new ErrorMessage();
        error.setTimestamp(LocalDateTime.now());
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorMessage> unauthorized(UnauthorizedException ex, WebRequest request) throws IOException {
        log.info("inside unauthorized exception-global exception handler");
        ErrorMessage error=new ErrorMessage();
        error.setTimestamp(LocalDateTime.now());
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }

}