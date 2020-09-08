package com.cognizant.dreams.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


@Data
public class ActionDTO implements Serializable{
	private long actionId;

	private String action;


	private UserDTO actionUser;

    public Date completedDate;

	private NotesDTO notes;

    public Date dueDate;
   
    private String retroSessionId;
    


    @Override
    public String toString() {
        return "ActionDTO{" +
                "actionId=" + actionId +
                ", action='" + action + '\'' +
                ", actionUser=" + actionUser +
                ", dueDate=" + dueDate +
                ", retroSessionId='" + retroSessionId + '\'' +
                ", completedDate=" +completedDate +
                '}';
    }
}
