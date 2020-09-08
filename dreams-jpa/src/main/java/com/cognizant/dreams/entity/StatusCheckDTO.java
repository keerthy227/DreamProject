package com.cognizant.dreams.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class StatusCheckDTO implements Serializable {

    private long id;

    private String currentScreen;

    private String retroSessionId;

    private long userId;

    private boolean statusOfScreen;

    private boolean statusOfNotes;

    private String role;

    @Override
    public String toString() {
        return "StatusCheck{" +
                "id=" + id +
                ", currentScreen='" + currentScreen + '\'' +
                ", userId=" + userId + '\'' +
                ", statusOfScreen=" + statusOfScreen +'\'' +
                ", statusOfNotes=" + statusOfNotes +'\'' +
                ", retroSessionId=" + retroSessionId +'\'' +
                ", role=" + role +'\'' +
                '}';
    }
}
