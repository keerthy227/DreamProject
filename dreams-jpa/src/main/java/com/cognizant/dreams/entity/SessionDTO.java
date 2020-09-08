package com.cognizant.dreams.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SessionDTO implements Serializable {
	private long id;

	private String role;

	private String retroSessionId;

	private String retroSessionName;

	private long userId;

    private TemplateDTO template;

    private String userName;

    private Date sessionDate;

    private String teamName;

    private boolean status;

    @JsonIgnore
    private TeamDTO team;

    @Override
    public String toString() {
        return "SessionDTO{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", retroSessionId='" + retroSessionId + '\'' +
                ", retroSessionName='" + retroSessionName + '\'' +
                ", userId=" + userId +
                ", template=" + template +
                ", userName='" + userName + '\'' +
                ", sessionDate=" + sessionDate +
                ", teamName='" + teamName + '\'' +
                ", status=" + status +
                '}';
    }
}
