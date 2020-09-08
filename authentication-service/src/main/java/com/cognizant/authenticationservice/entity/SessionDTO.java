package com.cognizant.authenticationservice.entity;

import java.util.List;

import lombok.Data;

@Data
public class SessionDTO {
    public long id;

    public String role;

    public String sessionId;

    public String sessionName;

    public long userId;

    private List<NotesDTO> notes;

    public TemplateDTO template;

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", sessionName='" + sessionName + '\'' +
                ", userId=" + userId +
                ", template=" + template +
                '}';
    }
}
