package com.cognizant.userservice.controller;

import com.cognizant.dreams.entity.StatusCheckDTO;
import com.cognizant.dreams.entity.TimerDTO;
import com.cognizant.userservice.exception.StatusServiceException;
import com.cognizant.userservice.exception.TimerServiceException;
import com.cognizant.userservice.service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StatusController {

    @Autowired
    private StatusServiceImpl statusService=null;

    @GetMapping("/{sessionId}")
    public List<StatusCheckDTO> getStatusForSession(@PathVariable String sessionId) throws StatusServiceException
    {
        return  statusService.getStatusForSession(sessionId);
    }

    @PostMapping
    public void saveStatus(@RequestBody StatusCheckDTO status) throws StatusServiceException
    {
        statusService.saveStatus(status);
    }
}
