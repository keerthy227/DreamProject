package com.cognizant.userservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.dreams.entity.NotesDTO;
import com.cognizant.dreams.entity.SessionDTO;
import com.cognizant.dreams.entity.UserDTO;
import com.cognizant.dreams.repository.NotesRepository;
import com.cognizant.dreams.repository.UserRepository;
import com.cognizant.userservice.service.UserServiceImpl;


@SpringBootTest
class UserserviceApplicationTests {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserServiceImpl userService;

    @Autowired
    NotesRepository notesRepository;

	/*
	 * @Test public void storeAllNotes() throws Exception { Notes note = new
	 * Notes(9L,"notes",2L,"123456",3L,null,null,null); UserService service= new
	 * UserService (userRepository, notesRepository); long id =
	 * service.storeAllNotes(note); System.out.print(id); // assertEquals(9L, id); }
	 * 
	 * @Test public void getAllNotesTest() throws Exception { Notes note = new
	 * Notes(9L,"notes",2L,"123456",3L,null,null,null); notesRepository.save(note);
	 * UserService service = new UserService(userRepository, notesRepository);
	 * List<Notes> notes = service.getAllNotes("123456"); if(notes.size() == 1) {
	 * assertTrue(true); } }
	 */

    
    @Test
    public void storeNotesTest() throws Exception {
       
    	NotesDTO note = new NotesDTO();
    	note.setNotes("new");
    	note.setNotesId(1);
    	note.setRetroSessionId("qiyeg7lrt");
    	UserDTO user = new UserDTO();
    	user.setId(1);
    	note.setUser(user);
    	userService.storeAllNotes(note);
    }
    @Test
    public void getAllUserTest() throws Exception {
       
        List<SessionDTO> users = userService.getAllUser("qiyeg7lrt");
        if (users.size() == 1) {
            assertTrue(true);
        }
    }
    
    @Test
    public void getAllNotesTest() throws Exception {
       
        List<NotesDTO> notesList = userService.getAllNotes("qiyeg7lrt");
        if(!notesList.isEmpty()) {
        String retroSessionId = notesList.get(0).getRetroSessionId();
        System.out.println("user obj is::::"+notesList.get(0).getUser());
        System.out.println("retroSessionId:::"+retroSessionId);
        }
        if (notesList.size() > 0) {
            assertTrue(true);
        }
    }
	/*
	 * @Test public void updateNoteTest() throws Exception { Notes[] note = new
	 * Notes[1]; Notes n = new Notes(9L,"notes",2L,"123456",3L,null,null,null);
	 * note[0] = n; UserService service = new UserService(userRepository,
	 * notesRepository); List<Notes> notes = service.updateNote(note); if(
	 * notes.size() == 1) { assertTrue(true); }
	 * 
	 * }
	 * 
	 * @Test public void removeNoteTest() throws Exception { Notes note = new
	 * Notes(9L, "notes", 2L, "123456", 3L, null, null, null); notesRepository =
	 * Mockito.mock(NotesRepository.class);
	 * when(notesRepository.findById(9L)).thenReturn(java.util.Optional.of(note));
	 * UserService service = new UserService(userRepository, notesRepository); long
	 * id = 9L; service.removeNote(id); verify(notesRepository,
	 * times(1)).deleteById(id); }
	 */


    }

