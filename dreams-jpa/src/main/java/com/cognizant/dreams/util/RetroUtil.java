package com.cognizant.dreams.util;

import com.cognizant.dreams.entity.*;
import com.cognizant.dreams.entity.jpa.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RetroUtil {

//	@Bean
//	public ModelMapper modelMapper() {
//		ModelMapper modelMapper = new ModelMapper();
//		return modelMapper;
//	}
	@Autowired
	private ModelMapper modelMapper;

	public UserDTO convertToUserDto(User user) {
		return modelMapper.map(user, UserDTO.class);
	}

	public NotesDTO convertToNotesDto(Notes notes) {
		return modelMapper.map(notes, NotesDTO.class);
	}

	public Notes convertToNotesJPA(NotesDTO notes) {
		return modelMapper.map(notes, Notes.class);
	}

	public CommentDTO convertToCommentsDto(Comment comment) {
		return modelMapper.map(comment, CommentDTO.class);
	}

	public Comment convertToCommentJPA(CommentDTO comment) {
		return modelMapper.map(comment, Comment.class);
	}

	public ActionDTO convertToActionDto(Action action) {
		return modelMapper.map(action, ActionDTO.class);
	}

	public Action convertToActionJPA(ActionDTO action) {
		return modelMapper.map(action, Action.class);
	}

	public TeamDTO convertToTeamDTO(Team Team){
		return modelMapper.map(Team,TeamDTO.class);
	}

	public Team convertToTeamJPA(TeamDTO Team){
		return modelMapper.map(Team,Team.class);
	}
	
	public ActionCommentsDTO convertToActionCommentsDto(ActionComments actionComments) {
		return modelMapper.map(actionComments, ActionCommentsDTO.class);
	}

	public ActionComments convertToActionCommentsJPA(ActionCommentsDTO actionComments) {
		return modelMapper.map(actionComments, ActionComments.class);
	}

	public VoteDTO convertToVoteDto(Vote vote) {
		return modelMapper.map(vote, VoteDTO.class);
	}

	public Vote convertToVoteJPA(VoteDTO vote) {
		return modelMapper.map(vote, Vote.class);
	}
	public ActionAssigned convertToActionAssignedJPA(ActionAssignedDTO actionAssigned) {
		return modelMapper.map(actionAssigned, ActionAssigned.class);
	}
	
	public RetroSession convertToSessionJPA(SessionDTO session) {
		return  modelMapper.map(session, RetroSession.class);
	}



	public TemplateDTO convertToTemplateDTO(Template template) {

		return  modelMapper.map(template, TemplateDTO.class);
	}

	public ActionAssignedDTO convertToActionAssignedDto(ActionAssigned actionAssigned) {
		return modelMapper.map(actionAssigned, ActionAssignedDTO.class);
	}

    public SessionDTO convertToSessionDto(RetroSession retroSession) {
		return modelMapper.map(retroSession, SessionDTO.class);
    }

	public Timer convertToTimerJPA(TimerDTO time) {
		return modelMapper.map(time, Timer.class);
	}
	public TimerDTO convertToTimerDTO(Timer time) {
		return modelMapper.map(time, TimerDTO.class);
	}

	public StatusCheck convertToStatusCheckJPA(StatusCheckDTO statusCheck) {
		return modelMapper.map(statusCheck, StatusCheck.class);
	}
	public StatusCheckDTO convertToStatusCheckDTO(StatusCheck statusCheck) {
		return modelMapper.map(statusCheck, StatusCheckDTO.class);
	}


    public TeamDTO converttoTeamDTO(Team Team){
        return modelMapper.map(Team,TeamDTO.class);
    }

    public Team converttoTeamJPA(TeamDTO Team){
        return modelMapper.map(Team,Team.class);
    }

}
