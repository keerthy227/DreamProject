package com.cognizant.authenticationservice.entity;

import lombok.Data;

@Data
public class ActionDTO {
    public long actionId;

    public String action;

    public UserDTO actionUser;

    public NotesDTO notes;

    @Override
    public String toString() {
        return "Action{" +
                "actionId=" + actionId +
                ", action='" + action + '\'' +
                '}';
    }
}
