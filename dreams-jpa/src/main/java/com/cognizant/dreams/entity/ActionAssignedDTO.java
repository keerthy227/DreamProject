package com.cognizant.dreams.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class ActionAssignedDTO implements Serializable{
	private long id;

	private long actionId;


	private UserDTO actionAssignedUser;

    public String retroSessionId;

    @Override
    public String toString() {
        return "ActionAssignedDTO{" +
                "id=" + id +
                ", actionId=" + actionId +
                ", actionAssignedUser=" + actionAssignedUser +
                ", retroSessionId='" + retroSessionId + '\'' +
                '}';
    }
}
