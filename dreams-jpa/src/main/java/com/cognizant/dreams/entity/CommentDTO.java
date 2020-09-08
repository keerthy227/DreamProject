package com.cognizant.dreams.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


@Data
public class CommentDTO implements Serializable {
	private long commentId;
   
	private String comment;

    @JsonBackReference
    private NotesDTO notes;


    private UserDTO commentUser;

    @Override
    public String toString() {
        return "CommentDTO{" +
                "commentId=" + commentId +
                ", comment='" + comment + '\'' +
                ", commentUser=" + commentUser +
                '}';
    }
}
