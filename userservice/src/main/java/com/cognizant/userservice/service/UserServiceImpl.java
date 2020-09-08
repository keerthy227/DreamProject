package com.cognizant.userservice.service;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.cognizant.dreams.entity.*;
import com.cognizant.dreams.entity.jpa.*;
import com.cognizant.dreams.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import com.cognizant.dreams.util.RetroUtil;
import com.cognizant.userservice.exception.UserServiceException;

import lombok.extern.slf4j.Slf4j;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


@Slf4j
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NotesRepository notesRepository;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ActionRepository actionRepository;

	@Autowired
	private VoteRepository voteRepository;

	@Autowired
	private ActionAssignedRepository actionAssignedRepository;
	
	@Autowired
	private ActionCommentsRepository actionCommentsRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private RetroUtil retroUtil;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	/**
	 * Helps in saving the notes to persistent layer
	 * 
	 * @param inputNotes
	 * @return
	 * @throws UserServiceException
	 */

	@CacheEvict(value="notes",allEntries=true)
	public Long storeAllNotes(NotesDTO inputNotes) throws UserServiceException {
		log.info("Inside storeAllNotes");
		try {
			Notes notes = retroUtil.convertToNotesJPA(inputNotes);
			Notes notesData = notesRepository.save(notes);
			return notesData.getNotesId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserServiceException(e.getMessage());
		}
	}

	/**
	 * Helps in removing notes from persistence layer
	 * 
	 * @param id
	 */
	@CacheEvict(value="notes",allEntries=true)
	public void removeNote(Long id) {
		notesRepository.deleteById(id);
	}

	@CacheEvict(value="notes",allEntries=true)
	public void postAction(ActionDTO actionObj) {
		actionRepository.save(retroUtil.convertToActionJPA(actionObj));
	}

	@CacheEvict(value="notes",allEntries=true)
	public void postActionComments(ActionCommentsDTO actionComments) {
		actionCommentsRepository.save(retroUtil.convertToActionCommentsJPA(actionComments));
	}

	@CacheEvict(value="notes",allEntries=true)
	public void postComment(CommentDTO comment) {
		commentRepository.save(retroUtil.convertToCommentJPA(comment));
	}

	@CacheEvict(value="notes",allEntries=true)
	public void postActionAssigned(ActionAssignedDTO actionAssigned) {
	    if(actionAssignedRepository.findByActionAssignedUser(actionAssigned.getActionId(),actionAssigned.getActionAssignedUser().getId())==null) {
            actionAssignedRepository.save(retroUtil.convertToActionAssignedJPA(actionAssigned));
        }
	}


	public List<ActionAssignedDTO> getAllActionAssigned(String sessionId) {
		log.info("Inside get action assigned function in service ");
		List<ActionAssigned> action = new ArrayList<>();
		List<ActionAssignedDTO> actionList = new ArrayList<>();
		action.addAll(actionAssignedRepository.findAllByRetroSessionId(sessionId));
		actionList.addAll(action.stream().map(obj ->retroUtil.convertToActionAssignedDto(obj)).collect(Collectors.toList()));
		return actionList;
	}

	@CacheEvict(value="notes",allEntries=true)
	public void updateAction(ActionDTO action) throws UserServiceException {
		log.info("Inside Update Action fun in service");
		actionRepository.save(retroUtil.convertToActionJPA(action));
	}

	@CacheEvict(value="notes",allEntries=true)
	public void removeAction(Long actionId) {
		actionRepository.deleteById(actionId);
	}

	public List<ActionDTO> getAllActions(String sessionId) {
		List<ActionDTO> actionList = new ArrayList<>();
			List<Action> dataList = actionRepository.findAllByRetroSessionId(sessionId);
			log.info("datalist"+dataList);
			if (!dataList.isEmpty()) {
				actionList.addAll(dataList.stream().map(obj ->retroUtil.convertToActionDto(obj)).collect(Collectors.toList()));
			}
			log.info("actionList"+actionList);
		return actionList;

	}
	
		public List<ActionCommentsDTO> getAllActionComments(String sessionId) {
		List<ActionCommentsDTO> actionCommentsList = new ArrayList<>();
		List<ActionComments> dataList = actionCommentsRepository.findAllByRetroSessionId(sessionId);
		log.info("datalist"+dataList);
		if (!dataList.isEmpty()) {
			actionCommentsList.addAll(dataList.stream().map(obj ->retroUtil.convertToActionCommentsDto(obj)).collect(Collectors.toList()));
		}
		log.info("actionList"+actionCommentsList);
		return actionCommentsList;

	}

	public List<ActionDTO> getAllExistingAction(String teamName, long userId){
		List<ActionDTO> existingAction = new ArrayList<>();
		long faciID = sessionRepository.getfacilitator(userId,teamName);
		log.info(""+ faciID);
		if(actionRepository.findAllExistingAction(teamName,faciID)!=null) {
			existingAction.addAll(actionRepository.findAllExistingAction(teamName, faciID).stream().map(obj -> retroUtil.convertToActionDto(obj)).collect(Collectors.toList()));
		}
		log.info(""+existingAction);
		return existingAction;



	}

	public List<ActionAssignedDTO> getAllExistingActionAssigned(String teamName, long userId){
		List<ActionAssignedDTO> existingActionAssigned = new ArrayList<>();
		long faciID = sessionRepository.getfacilitator(userId,teamName);
		log.info(""+ faciID);
		if(actionAssignedRepository.findAllExistingActionAssigned(teamName,faciID)!=null) {
			existingActionAssigned.addAll(actionAssignedRepository.findAllExistingActionAssigned(teamName, faciID).stream().map(obj -> retroUtil.convertToActionAssignedDto(obj)).collect(Collectors.toList()));
		}
		log.info(""+existingActionAssigned);
		return existingActionAssigned;



	}

	public List<ActionCommentsDTO> getExistingActionComments(String teamName, long userId){
		List<ActionCommentsDTO> existingActionComments = new ArrayList<>();
		long faciID = sessionRepository.getfacilitator(userId,teamName);
		log.info(""+ faciID);
		if(actionCommentsRepository.findAllExistingActionComments(teamName,faciID)!=null) {
			existingActionComments.addAll(actionCommentsRepository.findAllExistingActionComments(teamName, faciID).stream().map(obj -> retroUtil.convertToActionCommentsDto(obj)).collect(Collectors.toList()));
		}
		log.info(""+existingActionComments);
		return existingActionComments;



	}


	public List<CommentDTO> getAllComments(String sessionId) {
		List<Long> notesId = new ArrayList<>();
		List<CommentDTO> commentsList = new ArrayList<>();
		notesId.addAll(notesRepository.findAllNotesBySessionId(sessionId));
		log.info("notesId"+notesId);
		for (long i : notesId) {
			List<Comment> dataList = commentRepository.findAllCommentsById(i);
			log.info("datalist"+dataList);
			if (dataList != null && !dataList.isEmpty()) {
				commentsList.addAll(dataList.stream().map(obj ->retroUtil.convertToCommentsDto(obj)).collect(Collectors.toList()));
			}

		}
		log.info("commentslist"+commentsList);
		return commentsList;
	}
	
		/**
	 * This helps in fetching the user based on session id
	 * 
	 * @param sessionId
	 * @return
	 * @throws UserServiceException
	 */
		public List<UserDTO> getUser(String sessionId) throws UserServiceException {
		try {
			List<Long> userList = sessionRepository.findAllUserByRetroSessionId(sessionId);
			List<UserDTO> user = new ArrayList<>();
			for(long i :userList) {
				List<User> dataList = userRepository.findAllUserById(i);
				log.info("datalist"+dataList);
				if (dataList != null && !dataList.isEmpty()) {
					user.addAll(dataList.stream().map(obj ->retroUtil.convertToUserDto(obj)).collect(Collectors.toList()));
				}
			}
			//List<SessionDTO> result = userList.stream() .map(obj ->retroUtil.convertToSessionDto(obj)).collect(Collectors.toList());
			log.info("user db list size is ::::"+userList);
			return  user;
		} catch (Exception e) {
			throw new UserServiceException(e.getMessage());
		}
	}


	/**
	 * This helps in fetching the user based on session id
	 * 
	 * @param sessionId
	 * @return
	 * @throws UserServiceException
	 */
	public List<SessionDTO> getAllUser(String sessionId) throws UserServiceException {
		log.info(sessionId);
		log.info(""+sessionRepository.findAllByRetroSessionId(sessionId));
		try {
			List<RetroSession> userList = sessionRepository.findAllByRetroSessionId(sessionId);
			List<SessionDTO> result = userList.stream().map(obj ->retroUtil.convertToSessionDto(obj)).collect(Collectors.toList());
			log.info("user db list size is ::::"+userList);
			return  result;
		} catch (Exception e) {
			throw new UserServiceException(e.getMessage());
		}
	}



	/**
	 * This helps in updating the notes
	 * 
	 * @param notes
	 * @return
	 * @throws UserServiceException
	 */
	public List<NotesDTO> updateNote(NotesDTO[] notes) throws UserServiceException {
		try {
			List<Notes> result = Arrays.asList(notes).stream().map(obj ->retroUtil.convertToNotesJPA(obj))
					.collect(Collectors.toList());
			notesRepository.saveAll(result);
			Iterable<Notes> notesIter = notesRepository.findAll();
			List<NotesDTO> notesDTOList = StreamSupport.stream(notesIter.spliterator(), false)
					.map(obj ->retroUtil.convertToNotesDto(obj)).collect(Collectors.toList());
			return notesDTOList;
		} catch (Exception e) {
			throw new UserServiceException(e.getMessage());
		}
	}

	@Cacheable("notes")
	public List<NotesDTO> getAllNotes(String sessionId) throws UserServiceException{
		log.info("Entering getAllNotes");
		List<Notes> noteJPAList =  notesRepository.findAllNotesByRetroId(sessionId);
		List<NotesDTO> noteList = noteJPAList.stream().map(obj ->retroUtil.convertToNotesDto(obj)).collect(Collectors.toList());
		log.info("size is::::"+noteJPAList.size());
		return noteList;
	}

	@CacheEvict(value="notes",allEntries=true)
	public void groupNotes(NotesDTO[] notes) throws UserServiceException{
		try {
			List<Notes> groupNotes = Arrays.asList(notes).stream().map(obj ->retroUtil.convertToNotesJPA(obj))
					.collect(Collectors.toList());
			log.info("groupList"+groupNotes);
			for(Notes i : groupNotes) {
				Optional<Notes> note = notesRepository.findById(i.getNotesId());
				Notes note1 = note.get();
				note1.setGroupId(i.getGroupId());
				notesRepository.save(note1);
			}
		} catch (Exception e) {
			throw new UserServiceException(e.getMessage());
		}
	}


	@CacheEvict(value="notes",allEntries=true)
	public void ungroupNotes(NotesDTO[] notes) throws UserServiceException{
		try {
			List<Notes> groupNotes = Arrays.asList(notes).stream().map(obj ->retroUtil.convertToNotesJPA(obj))
					.collect(Collectors.toList());
			log.info("ungroupList"+groupNotes);
			for(Notes i : groupNotes) {
				Optional<Notes> note = notesRepository.findById(i.getNotesId());
				Notes note1 = note.get();
				note1.setGroupId(0);
				notesRepository.save(note1);
			}
		} catch (Exception e) {
			throw new UserServiceException(e.getMessage());
		}
	}
	
	 public void exitretro(String SessionId){
		List<RetroSession> getRetro = new ArrayList<>();
	   getRetro= sessionRepository.findAllByRetroSessionId(SessionId);

	   for(RetroSession i : getRetro){
	       i.setStatus(false);
	       sessionRepository.save(i);
       }

	 }

	@CacheEvict(value="notes",allEntries=true)
	public void updateVote(VoteDTO vote) throws UserServiceException {

		try {

			Vote votes = retroUtil.convertToVoteJPA(vote);
			log.info("updateVote func in userservice"+votes);

				if(voteRepository.findByNoteId(votes.getNotes().getNotesId(),votes.getUserId()) != null) {

					log.info("Inside if");

					Long voteId = voteRepository.findByNoteId(votes.getNotes().getNotesId(), votes.getUserId());

					votes.setVoteId(voteId);

					voteRepository.save(votes);

				}

				else {

					log.info("Inside else");

					voteRepository.save(votes);

				}

		} catch (Exception e) {

			throw new UserServiceException(e.getMessage());

		}

	}
	
	public void sendEmailWithTemplate(MailDTO mailDTO) throws MessagingException {

		Map<String, Object> model = new HashMap<>();
		model.put("name", "Developer!");
		model.put("location", "United States");
		model.put("sign", "Java Developer");
		mailDTO.setProps(model);

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,
				MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

//		helper.addAttachment("template-cover.png", new ClassPathResource("javabydeveloper-email.PNG"));

		Context context = new Context();
		context.setVariables(mailDTO.getProps());
		System.out.println(context.getVariable("name"));

		String html = templateEngine.process("xmail-template", context);

//        helper.setTo(mailDTO.getToBeSentMail());
		helper.setText(html, true);
		helper.setSubject(mailDTO.getSubject());
		helper.setFrom(mailDTO.getFromMail());

		javaMailSender.send(message);

	}

	public void sendEmail(MailDTO mailDTO) {

		SimpleMailMessage msg = new SimpleMailMessage();

		if (mailDTO.getToBeSentMail() != null) {
			for (String mail : mailDTO.getToBeSentMail()) {
				msg.setTo(mail);
				System.out.println(msg);
			}
			msg.setFrom(mailDTO.getFromMail());
			msg.setSubject(mailDTO.getSubject());
			msg.setText(mailDTO.getText());
			javaMailSender.send(msg);

		}
	}

}
