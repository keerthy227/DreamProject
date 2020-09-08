package com.cognizant.sessionservice.controller;

import com.cognizant.dreams.entity.TeamDTO;
import com.cognizant.dreams.entity.jpa.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dreams.entity.SessionDTO;
import com.cognizant.dreams.entity.TemplateDTO;
import com.cognizant.sessionservice.exception.SessionServiceException;
import com.cognizant.sessionservice.service.SessionServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
public class SessionController {
    @Autowired
    SessionServiceImpl sessionService;

    @PostMapping("/create")
    public void create(@RequestBody SessionDTO session) throws SessionServiceException {
        sessionService.create(session);
    }

    @PostMapping("/join")
    public void join(@RequestBody SessionDTO session) throws SessionServiceException {
        sessionService.join(session);
    }

    @GetMapping("/template/{id}")
    public TemplateDTO FindTemplate(@PathVariable String id) throws SessionServiceException{
        return sessionService.findAlltemplate(id);
    }


    @PostMapping("/team")
    public void team(@RequestBody TeamDTO team) throws SessionServiceException {
        sessionService.createteam(team);
    }

    @GetMapping("/getteams/{id}")
    public List<TeamDTO> getTeam(@PathVariable long id) {
        return sessionService.getTeam(id);
    }

    @GetMapping("/getallteamsession/{teamname}/{id}")
    public List<SessionDTO> getallteamsession(@PathVariable String teamname,@PathVariable long id){
        return sessionService.getallteamsession(teamname,id);
    }

    @GetMapping("/getjoiningteam/{id}")
    public SessionDTO getSession(@PathVariable String id) {
        return sessionService.getsession(id);
    }

    @GetMapping("/getteammembers/{teamname}")
    public List<TeamDTO> getTeamMembers(@PathVariable  String teamname) throws SessionServiceException {
        return  sessionService.getTeamMembers(teamname);
    }

}
