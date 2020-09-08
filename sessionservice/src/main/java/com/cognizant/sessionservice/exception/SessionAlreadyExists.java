package com.cognizant.sessionservice.exception;

public class SessionAlreadyExists extends Exception {
    public SessionAlreadyExists(){

        super("Session Already Exists");
    }
}
