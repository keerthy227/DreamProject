package com.cognizant.sessionservice.service;

import com.cognizant.dreams.entity.TeamDTO;
import com.cognizant.dreams.entity.jpa.RetroSession;
import com.cognizant.dreams.entity.jpa.Team;
import com.cognizant.dreams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dreams.entity.SessionDTO;
import com.cognizant.dreams.entity.TemplateDTO;
import com.cognizant.dreams.repository.SessionRepository;
import com.cognizant.dreams.repository.TemplateRepository;
import com.cognizant.dreams.util.RetroUtil;
import com.cognizant.sessionservice.exception.SessionServiceException;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SessionServiceImpl implements SessionService{
	

    
   @Autowired
   RetroUtil retroUtil;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TemplateRepository templateRepository;

    public void create(SessionDTO session) throws SessionServiceException {

    	try {
        Long session1 = sessionRepository.findCount(session.getRetroSessionId());
        if(session1==0){

            TeamDTO team =retroUtil.converttoTeamDTO( teamRepository.getexistingTeam(session.getTeamName(),session.getUserId()));
            session.setTeam(team);
//            log.info(String.valueOf(session));
            sessionRepository.save(retroUtil.convertToSessionJPA(session));

        }else {

            throw new SessionServiceException("Session Already Exists");

        }
    	}catch (Exception e) {
    		throw new SessionServiceException(e.getMessage());
		}
    }



    public void join(SessionDTO session) throws SessionServiceException {
    	try {
        Long session1 = sessionRepository.findCount(session.getRetroSessionId());
        if(session1==0){
            throw new SessionServiceException("Session Not Found");
        }else {
            Long session2 =sessionRepository.findCountToSave(session.getRetroSessionId(),
                    session.getUserId());
            if(session2 == 0)
                sessionRepository.save(retroUtil.convertToSessionJPA(session));
        }
    	}catch(Exception e) {
    		throw new SessionServiceException(e.getMessage());
    	}
    }


    public void createteam(TeamDTO team) throws SessionServiceException {

         try {
             if (teamRepository.getexistingTeam(team.getTeamName(), team.getUserId()) == null) {
//                 log.info(""+teamRepository.getexistingTeam(team.getTeamName(), team.getUserId()));
                 teamRepository.save(retroUtil.converttoTeamJPA(team));
             } else {
                 throw new SessionServiceException("Team Name already exist with this ID ");
             }
         }catch (Exception e){
             throw new SessionServiceException(e.getMessage());
         }

    }

    public List<TeamDTO> getTeam(long id) {
        List<TeamDTO> teamName = new ArrayList<>();
        if (teamRepository.getTeam(id) != null) {
//            teamName.addAll(teamRepository.getTeam(id));
             teamName.addAll(teamRepository.getTeam(id).stream().map(obj->retroUtil.converttoTeamDTO(obj)).collect(Collectors.toList()));
//            teamName = teamRepository.getTeam(id);
        }
        return teamName;
    }


    public List<SessionDTO> getallteamsession(String teamname, long id)  {
        List<SessionDTO> getAllteamsession = new ArrayList<>();
        if(sessionRepository.getallteamsession(teamname,id)!=null){
            getAllteamsession.addAll(sessionRepository.getallteamsession(teamname,id).stream().map(obj->retroUtil.convertToSessionDto(obj)).collect(Collectors.toList()));
//            getAllteamsession = sessionRepository.getallteamsession(teamname,id);
        }
        return getAllteamsession;
    }

    public SessionDTO getsession(String id)  {
        SessionDTO session = null;
        if(sessionRepository.getsessiondetails(id)!=null){
            session=retroUtil.convertToSessionDto(sessionRepository.getsessiondetails(id));
        }
        return session;
    }

    public TemplateDTO findAlltemplate(String id) throws SessionServiceException{
    	try {
    	    RetroSession retro = sessionRepository.findByRetroSessionIdAndRole(id,"facilitator");
//    	    log.info("retro"+retro);
        return retroUtil.convertToTemplateDTO(templateRepository.findtemplate(retro.getTemplate().getId()));
    	}catch(Exception e) {
    		throw new SessionServiceException(e.getMessage());
    		
    	}
    }



    public List<TeamDTO> getTeamMembers(String teamname) throws SessionServiceException{
        try{
            List<TeamDTO> team= new ArrayList<>();
            List<Team> teamList = teamRepository.getTeamMembers(teamname);
            if (!teamList.isEmpty()) {
                team.addAll(teamList.stream().map(obj ->retroUtil.converttoTeamDTO(obj)).collect(Collectors.toList()));
            }
//            log.info("team mebers",teamList);
            return team;
        }
        catch(Exception e) {
            throw new SessionServiceException(e.getMessage());
        }
    }

	

}
