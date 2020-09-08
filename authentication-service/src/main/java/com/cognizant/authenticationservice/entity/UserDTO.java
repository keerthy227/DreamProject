package com.cognizant.authenticationservice.entity;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
    public long id;
    public String userName;
    public String firstName;
    public String lastName;
    public String password;
    public String contact;
    public String email;

    public List<NotesDTO> notes;

    public List<CommentDTO> comments;



    public List<ActionDTO> actions;

    private List<ActionAssignedDTO> actionAssigned;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", notes=" + notes +
                ", comments=" + comments +
                ", actions=" + actions +
                ", actionAssigned=" + actionAssigned +
                '}';
    }
}
