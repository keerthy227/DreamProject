package com.cognizant.authenticationservice.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.dreams.entity.jpa.User;
import com.cognizant.dreams.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService{
private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);
	
	
	@Autowired
	UserRepository userRepository;



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if(user==null){
			throw new UsernameNotFoundException("User not found!");
		}
		else
		{
			LOGGER.info("user is:"+user);
			AppUser appUser = new AppUser(userRepository.findByUserName(username));
			return appUser;
		}
		
	}

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public void signup(User newUser) throws UserAlreadyExistsException{
		LOGGER.info("NEW USER IS: "+newUser);
		//	User user = userRepository.findByUserName(newUser.getUserName());
		User user = userRepository.findByEmail(newUser.getEmail());
		LOGGER.info("NEW USER IS: "+user);
		if(user != null){

			throw new UserAlreadyExistsException();
		} else {

			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = bCryptPasswordEncoder.encode(newUser.getPassword());
			newUser.setPassword(encodedPassword);
			StringBuilder displayNameBuilder = new StringBuilder();
			String userName=newUser.getUserName();
			int len=userName.length();
			int flag=0;
			int j=0;
			for(int i =0; i< len; i++){
				LOGGER.info("INSIDE FOR LOOP");
				if(userName.charAt(i)==' ')
				{
					LOGGER.info("inside if condition");
					j=i;
					flag=1;
					break;
				}
			}
			if(flag==0) {
				displayNameBuilder.append(newUser.getUserName().charAt(0));
				displayNameBuilder.append(newUser.getUserName().charAt(1));
			}
			else{
				displayNameBuilder.append(newUser.getUserName().charAt(0));
				displayNameBuilder.append(newUser.getUserName().charAt(j+1));
			}

			LOGGER.info("value"+ flag);
			LOGGER.info("thumbnail"+displayNameBuilder);
			newUser.setDisplayName(displayNameBuilder.toString());
			userRepository.save(newUser);
		}

	}



}
