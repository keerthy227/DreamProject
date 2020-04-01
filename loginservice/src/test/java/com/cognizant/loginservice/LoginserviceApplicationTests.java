/*
package com.cognizant.LoginMicroservice;

import com.cognizant.LoginMicroservice.Exception.UsernameNotFound;
import com.cognizant.LoginMicroservice.Model.AppUser;
import com.cognizant.LoginMicroservice.Model.User;
import com.cognizant.LoginMicroservice.Service.AppUserDetailsService;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginMicroserviceApplicationTests {


	private static final Logger LOGGER = LoggerFactory.getLogger(LoginMicroserviceApplicationTests.class);

	@Test
	public void mockTestLoadUserByUsername() {


		User user = new User();
		user.setId(5);
		user.setUsername("test1");
		user.setFirstname("test1");
		user.setLastname("test1");
		user.setGender("male");
		user.setRole("user");
		user.setContactnumber("7418529630");
		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		UserRepository userRepository = Mockito.mock(UserRepository.class);
		when(userRepository.findByUsername("test1")).thenReturn(java.util.Optional.of(user));
		AppUserDetailsService appUserDetailsService = new AppUserDetailsService(userRepository);
		UserDetails userdetails = appUserDetailsService.loadUserByUsername("test1");
		String expectedUsername = "test1";
		String expectedPassword = "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK";
		assertEquals(expectedUsername, user.getUsername());
		assertEquals(expectedPassword, user.getPassword());
		System.out.println(user);

	}


	@Test
	public void mockTestLoadByUserNameWithUserNotFound()  {
		assertThrows(UsernameNotFound.class,()-> {
			User user = new User();
			user.setId(51);
			user.setUsername("test1");
			user.setFirstname("test1");
			user.setLastname("test1");
			user.setGender("male");
			user.setRole("user");
			user.setContactnumber("7418529630");
			user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
			UserRepository userRepository = Mockito.mock(UserRepository.class);
			when(userRepository.findByUsername("test1")).thenReturn(java.util.Optional.of(user));
			AppUserDetailsService appUserDetailsService = new AppUserDetailsService(userRepository);
			AppUser user1 = (AppUser) appUserDetailsService.loadUserByUsername("test9");
		});
	}
}











*/
