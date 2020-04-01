/*
package com.cognizant.LoginMicroservice.controller;

import com.cognizant.LoginMicroservice.Model.User;
import com.cognizant.LoginMicroservice.Service.AppUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class LoginMicroserviceApplicationControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginMicroserviceApplicationControllerTest.class);

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }


    @Test
    public void postUser() throws Exception {

       User user = new User();
       user.setId(97458);
       user.setUsername("user");
       user.setFirstname("test1");
       user.setLastname("test1");
       user.setGender("male");
       user.setRole("user");
       user.setContactnumber("7418529630");
       user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        when(userRepository.findByUsername("user")).thenReturn(java.util.Optional.of(user));
        AppUserDetailsService appUserDetailsService = new AppUserDetailsService(userRepository);
        UserDetails userdetails = appUserDetailsService.loadUserByUsername("user");
        mockMvc.perform(get("/authenticate").header("Authorization","Basic dXNlcjoxMjM0NTY3OA=="))
                .andExpect(status().isCreated());

    }





    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
*/
