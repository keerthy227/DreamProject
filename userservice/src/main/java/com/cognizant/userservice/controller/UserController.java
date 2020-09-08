package com.cognizant.userservice.controller;

import java.util.List;

import com.cognizant.dreams.entity.*;
import com.cognizant.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.userservice.exception.UserServiceException;
import com.cognizant.userservice.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

import javax.mail.MessagingException;

@RestController
@Slf4j
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Value("${is.mail.template}")
    private boolean isMailTemplate;
	
    @Autowired
    private UserServiceImpl userService=null;

    @Autowired
    private UserService service;
	
	@GetMapping("/getUser/{sessionId}")
    public List<UserDTO> getUser(@PathVariable String sessionId) throws UserServiceException
    {
        return userService.getUser(sessionId);
    }

    @GetMapping("/{sessionId}")
    public List<SessionDTO> getAllUser(@PathVariable String sessionId) throws UserServiceException
    {
        return userService.getAllUser(sessionId);
    }

    @PostMapping("/removeAction")
    public void removeAction(@RequestBody Long actionId) {
        userService.removeAction(actionId);
    }

  
    @PostMapping("/store")
    public Long storeAllNotes(@RequestBody NotesDTO InputNotesList)throws UserServiceException{
        log.info("inside controller"+InputNotesList);
        return userService.storeAllNotes(InputNotesList);
    }

    @PutMapping("/update")
    public List<NotesDTO> updateNote(@RequestBody NotesDTO[] notes)throws UserServiceException {
        return userService.updateNote(notes);
    }

    @PutMapping("/postVote")
    public void postVote(@RequestBody VoteDTO vote) throws UserServiceException {
        log.info("Inside Post Vote function in controller" +vote);
        userService.updateVote(vote);
    }
    @PutMapping("/group")
    public void groupNotes(@RequestBody NotesDTO[] notes) throws UserServiceException{
        userService.groupNotes(notes);
    }

    @PutMapping("/ungroup")
    public void ungroupNotes(@RequestBody NotesDTO[] notes) throws UserServiceException{
        userService.ungroupNotes(notes);
    }

   @GetMapping("/getexistingaction/{teamname}/{id}")
   public List<ActionDTO> getexistingaction(@PathVariable String teamname,@PathVariable long id){
        return userService.getAllExistingAction(teamname,id);

   }

    @GetMapping("/getExistingActionComments/{teamname}/{id}")
    public List<ActionCommentsDTO> getExistingActionComments(@PathVariable String teamname,@PathVariable long id) throws UserServiceException {
        log.info("Inside get Exist Action Comments function in controller");
        return userService.getExistingActionComments(teamname, id);
    }

    @GetMapping("/getexistingactionAssigned/{teamname}/{id}")
    public List<ActionAssignedDTO> getexistingactionAssigned(@PathVariable String teamname,@PathVariable long id){
        return userService.getAllExistingActionAssigned(teamname,id);

    }

    @PostMapping("/remove")
    public void removeNote(@RequestBody Long removeNoteId) throws UserServiceException{

        userService.removeNote(removeNoteId);
    }

    @PutMapping("/endsession")
    public void endsession(@RequestBody String sessionID){
        userService.exitretro(sessionID);
    }

    @GetMapping("/comment/{sessionId}")
    public List<CommentDTO> getAllComments(@PathVariable String sessionId){
    return userService.getAllComments(sessionId);
    }

    @GetMapping("action/{sessionId}")
    public List<ActionDTO> getAllActions(@PathVariable String sessionId) {
        return userService.getAllActions(sessionId);
    }
    

    @PostMapping("/postComment")
    public void postComment(@RequestBody CommentDTO comment) {
        userService.postComment(comment);
    }

    @PostMapping("/postAction")
    public void postAction(@RequestBody ActionDTO action) {
        log.info("action"+action);
        userService.postAction(action);
    }
	
	@PostMapping("/postActionComments")
    public void postActionComments(@RequestBody ActionCommentsDTO actionComments) {
        log.info("Inside Post ActionComments function in controller" +actionComments);
        userService.postActionComments(actionComments);
    }

    @PostMapping("/postActionAssigned")
    public void postActionAssigned(@RequestBody ActionAssignedDTO actionAssigned) {
        userService.postActionAssigned(actionAssigned);
    }
    
    @GetMapping("/notes/{sessionId}")
    public List<NotesDTO> getAllNotes(@PathVariable String sessionId) throws UserServiceException {
        return userService.getAllNotes(sessionId);
    }

    @GetMapping("/getActionAssigned/{sessionId}")
    public List<ActionAssignedDTO> getAllActionAssigned(@PathVariable String sessionId) throws UserServiceException {
        log.info("Inside get Action Assigned function in controller");
        return userService.getAllActionAssigned(sessionId);
    }

   @GetMapping("/getActionComments/{sessionId}")
    public List<ActionCommentsDTO> getAllActionComments(@PathVariable String sessionId) throws UserServiceException {
        log.info("Inside get Action Comments function in controller");
        return userService.getAllActionComments(sessionId);
    }
	
    @PutMapping("/updateAction")
    public void updateAction(@RequestBody ActionDTO action) throws Exception {
        log.info("Inside Update Action function in controller");
        log.info(""+action);
        userService.updateAction(action);
    }
	
	@PostMapping("/sendEmail")
    public void sendEmail(@RequestBody MailDTO mailDTO) throws MessagingException {
        log.info("start of mail");
        if(isMailTemplate ){
            userService.sendEmailWithTemplate(mailDTO);
        }else{
            userService.sendEmail(mailDTO);
        }
        log.info("mail sent!");
    }

}
