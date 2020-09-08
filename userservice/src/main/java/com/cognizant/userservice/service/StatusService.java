package com.cognizant.userservice.service;


import com.cognizant.dreams.entity.StatusCheckDTO;
import com.cognizant.dreams.entity.jpa.StatusCheck;
import com.cognizant.userservice.exception.StatusServiceException;

import java.util.List;

public interface StatusService {

    public List<StatusCheckDTO> getStatusForSession(String sessionId) throws StatusServiceException;


    public void saveStatus(StatusCheckDTO time) throws StatusServiceException;
}
