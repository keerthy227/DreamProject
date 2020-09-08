package com.cognizant.authenticationservice.entity;

import lombok.Data;

@Data
public class ActionAssignedDTO {
    public long id;
    public long actionId;
    public UserDTO actionAssignedUser;

    @Override
    public String toString() {
        return "ActionAssigned{" +
                "id=" + id +
                ", actionId=" + actionId +
                '}';
    }
}
