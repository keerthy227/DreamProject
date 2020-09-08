package com.cognizant.userservice.service;

import java.util.List;

import com.cognizant.dreams.entity.*;
import com.cognizant.dreams.entity.jpa.ActionAssigned;
import org.springframework.stereotype.Service;

import com.cognizant.userservice.exception.UserServiceException;

@Service
public interface UserService {

	
	public Long storeAllNotes(NotesDTO inputNotes) throws UserServiceException;
	
	public void removeNote(Long id) throws UserServiceException;

	public void removeAction(Long id);

	public void postAction(ActionDTO action);
	public void postActionComments(ActionCommentsDTO actionComments);


	public List<ActionCommentsDTO> getAllActionComments(String sessionId);

	public void updateVote(VoteDTO vote) throws UserServiceException ;

	public void postComment(CommentDTO comment);

	public void postActionAssigned(ActionAssignedDTO actionAssigned);
	
	public List<ActionAssignedDTO> getAllActionAssigned(String sessionId);
	
		
	public List<UserDTO> getUser(String sessionId) throws UserServiceException;

	public List<SessionDTO> getAllUser(String sessionId) throws UserServiceException;

	public void updateAction(ActionDTO action) throws UserServiceException;

	public List<ActionDTO> getAllActions(String sessionId);

	public List<ActionDTO> getAllExistingAction(String teamname, long id);

	public List<ActionAssignedDTO> getAllExistingActionAssigned(String teamname, long id);

	public List<ActionCommentsDTO> getExistingActionComments(String teamname, long id);

	public List<CommentDTO> getAllComments(String sessionId);

	public  List<NotesDTO> updateNote(NotesDTO[] notes) throws UserServiceException ;
	
	public List<NotesDTO> getAllNotes(String sessionId) throws UserServiceException ;

    public void groupNotes(NotesDTO[] notes) throws UserServiceException;

	public void ungroupNotes(NotesDTO[] notes) throws UserServiceException;
	
	public void sendEmail(MailDTO mailDTO);
}
