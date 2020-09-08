package com.cognizant.dreams.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class UserDTO implements Serializable{
	private long id;
    
	private String userName;




	private String displayName;
    
	private String password;
   
	private String email;

	@Override
	public String toString() {
		return "UserDTO{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", displayName='" + displayName + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				'}';
	}


}
