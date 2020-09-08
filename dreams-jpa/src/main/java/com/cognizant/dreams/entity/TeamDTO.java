package com.cognizant.dreams.entity;

import com.cognizant.dreams.entity.jpa.RetroSession;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class TeamDTO implements Serializable {

    private long id;

    private String teamName;

    private Long userId;

    private String role;

    private String userName;
    private String displayName;


    @Override
    public String toString() {
        return "TeamDTO{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", userId=" + userId +
                ", role='" + role + '\'' +
                ", userName='" + userName + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
