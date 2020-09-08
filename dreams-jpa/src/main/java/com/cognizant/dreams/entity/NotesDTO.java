package com.cognizant.dreams.entity;

import java.io.Serializable;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class NotesDTO implements Serializable {
	private long notesId;

    private String notes;

    private long getNotesId;
    
    private String retroSessionId;
    
    private String retroSessionName;

    private List<VoteDTO> voteList;

    private long groupId;

    private String groupName;

    private UserDTO user;

    private List<CommentDTO> commentList;

    @JsonBackReference
    private List<ActionDTO> actionList;


    @Override
    public String toString() {
        return "NotesDTO{" +
                "notesId=" + notesId +
                ", notes='" + notes + '\'' +
                ", getNotesId=" + getNotesId +
                ", retroSessionId='" + retroSessionId + '\'' +
                ", retroSessionName='" + retroSessionName + '\'' +
                ", votes=" + voteList +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", user=" + user +
                ", commentList=" + commentList +
                ", actionList=" + actionList +

                '}';
    }
}
