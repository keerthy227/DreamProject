package com.cognizant.userdata.adminservicetest;

import com.cognizant.userdata.Exception.UsernameNotFoundException;
import com.cognizant.userdata.model.User;
import com.cognizant.userdata.repository.UserRepository;
import com.cognizant.userdata.service.DataService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.any;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class AdminServiceTest {
    @Test
   public void getAllUserTest() throws Exception {

        User user = new User(5L, "my", "m", "r", "1236547890", "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK",
                null,"male", "user");
        User userOne = new User(6L, "ra", "m", "r", "1236547890", "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK",
               null, "male", "user");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(userOne);
        UserRepository userListRepository = Mockito.mock(UserRepository.class);
        when(userListRepository.findAll()).thenReturn(list);
        DataService adminService = new DataService(userListRepository);
        assertEquals(2,adminService.getAllUsers().size());

    }

    @Test
    public void getAllUserWithNullTest() {
        assertThrows(UsernameNotFoundException.class,()-> {
        List<User> list = new ArrayList<>();
        UserRepository userListRepository = Mockito.mock(UserRepository.class);
        when(userListRepository.findAll()).thenReturn(list);
        DataService adminService = new DataService(userListRepository);
        adminService.getAllUsers();
        });
    }

    @Test
    public void getUserByIdTest() throws Exception {
        User user = new User(5L, "my", "m", "r", "1236547890", "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK",
                null,"male", "user");
        UserRepository userListRepository = Mockito.mock(UserRepository.class);
        when(userListRepository.findById(5L)).thenReturn(java.util.Optional.of(user));
        DataService adminService = new DataService(userListRepository);
        assertTrue( adminService.getUserById(5L).isPresent());
    }

    @Test
    public void getUserByIdTestWithNull() {
        assertThrows(UsernameNotFoundException.class, () -> {
            User user = new User();
            UserRepository userListRepository = Mockito.mock(UserRepository.class);
            when(userListRepository.findById(6L)).thenReturn(java.util.Optional.of(user));
            DataService adminService = new DataService(userListRepository);
            adminService.getUserById(6L);
        });
    }


    @Test
    public void removeUserTest()  {
        User user = new User(5L, "my", "m", "r", "1236547890", "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK",
                null, "male", "user");
        User userOne = new User(6L, "my1", "m", "r", "1236547890", "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK",
                null, "male", "user");
        UserRepository userListRepository = Mockito.mock(UserRepository.class);
         when(userListRepository.findById(5L)).thenReturn(java.util.Optional.of(user));
        when(userListRepository.findById(6L)).thenReturn(java.util.Optional.of(userOne));
        DataService adminService = new DataService(userListRepository);
        Long[] id ={5L,6L};
        adminService.remove(id);
         for(int i=0;i<=1;i++) {
             verify(userListRepository, times(1)).deleteById(id[i]);
         }
    }

        @Test
        public void modifyUserTest(){
        User user = new User(5L, "my", "m", "r", "1236547890", "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK",
                    null,"male", "user");
       UserRepository userListRepository = Mockito.mock(UserRepository.class);
        when(userListRepository.save(any(User.class))).thenReturn(user);
        DataService adminService = new DataService(userListRepository);
        adminService.updateUserById(user);
        verify(userListRepository, times(1)).save(any(User.class));

    }
}
