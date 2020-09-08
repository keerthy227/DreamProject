package com.cognizant.userservice.service;


import com.cognizant.dreams.entity.TimerDTO;
import com.cognizant.userservice.exception.TimerServiceException;


public interface TimerService {

    public TimerDTO getTimeForSession(String sessionId) throws TimerServiceException;


    public String saveTime(TimerDTO time) throws TimerServiceException;
}
