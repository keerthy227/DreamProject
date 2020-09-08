package com.cognizant.dreams.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class VoteDTO implements Serializable {
    private Long voteId;

    private Long votes;

    @JsonBackReference
    private NotesDTO notes;

    private  Long userId;

    private String retroSessionId;

    @Override
    public String toString() {
        return "VoteDTO{" +
                "voteId=" + voteId +
                ", votes=" + votes +
                ", userId=" + userId +
                ", retroSessionId='" + retroSessionId + '\'' +
                '}';
    }
}
