package com.cognizant.authenticationservice.entity;

import lombok.Data;

@Data
public class CommentDTO {
    public long commentId;
    public String comment;
    public NotesDTO notes;
    public UserDTO commentUser;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
