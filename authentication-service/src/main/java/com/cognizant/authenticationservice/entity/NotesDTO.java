package com.cognizant.authenticationservice.entity;

import java.util.List;

import lombok.Data;

@Data
public class NotesDTO {
    public long notesId;

    public String notes;

    public long getNotesId;

    public SessionDTO session;

    public long votes;

    public UserDTO user;

    public List<CommentDTO> commentList;

    public List<ActionDTO> actionList;

    @Override
    public String toString() {
        return "Notes{" +
                "notesId=" + notesId +
                ", notes='" + notes + '\'' +
                ", getNotesId=" + getNotesId +
                ", session=" + session +
                ", votes=" + votes +
                ", commentList=" + commentList +
                ", actionList=" + actionList +
                '}';
    }
}
