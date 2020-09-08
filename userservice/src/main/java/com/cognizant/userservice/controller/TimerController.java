package com.cognizant.userservice.controller;

import com.cognizant.dreams.entity.TimerDTO;
import com.cognizant.userservice.exception.TimerServiceException;
import com.cognizant.userservice.service.TimerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/timer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TimerController {

    @Autowired
    private TimerServiceImpl timerService=null;

    @GetMapping("/{sessionId}")
    public TimerDTO getTImeForSession(@PathVariable String sessionId) throws TimerServiceException
    {
        return  timerService.getTimeForSession(sessionId);
    }

    @PostMapping
    public String saveTime(@RequestBody TimerDTO time) throws TimerServiceException
    {
        return timerService.saveTime(time);
    }


}
