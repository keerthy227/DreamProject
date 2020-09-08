package com.cognizant.sessionservice.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);





	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.cors();
//		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/users").permitAll().anyRequest();
//		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/menu-items").permitAll()
//				.anyRequest().authenticated().and().addFilter(new JwtAuthorizationFilter(authenticationManager()));


//		  httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().
//		  antMatchers("/authenticate") .hasAnyRole().anyRequest().authenticated().and() .addFilter(new
//		  JwtAuthorizationFilter(authenticationManager()));

		  httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().anyRequest().permitAll();
//		  httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/join").permitAll().anyRequest();

	}


}
