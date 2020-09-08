package com.cognizant.sessionservice.service;

import com.cognizant.dreams.entity.SessionDTO;
import com.cognizant.dreams.entity.TeamDTO;
import com.cognizant.dreams.entity.TemplateDTO;
import com.cognizant.dreams.entity.jpa.Team;
import com.cognizant.sessionservice.exception.SessionServiceException;

import java.util.List;

public interface SessionService {
	
	  public void create(SessionDTO session) throws SessionServiceException;
	  
	  public TemplateDTO findAlltemplate(String id) throws SessionServiceException;
	  
	  public void join(SessionDTO session) throws SessionServiceException;

	public void createteam(TeamDTO team) throws SessionServiceException;

	public List<TeamDTO> getTeam(long id);

	public List<SessionDTO> getallteamsession(String teamname, long id);

	public SessionDTO getsession(String id);

	public List<TeamDTO> getTeamMembers(String teamname) throws SessionServiceException;







}
