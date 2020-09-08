package com.cognizant.dreams.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="StatusCheck")
public class StatusCheck implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "current_screen")
    private String currentScreen;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "status_of_screen")
    private boolean statusOfScreen;

    @Column(name = "retro_session_id")
    private String retroSessionId;

    @Column(name = "status_of_notes")
    private boolean statusOfNotes;

    @Column(name = "role")
    private String role;

    @Override
    public String toString() {
        return "StatusCheck{" +
                "id=" + id +
                ", currentScreen='" + currentScreen + '\'' +
                ", userId=" + userId + '\'' +
                ", statusOfScreen=" + statusOfScreen + '\'' +
                ", statusOfNotes=" + statusOfNotes + '\'' +
                ", retroSessionId=" + retroSessionId +'\'' +
                ", role=" + role +'\'' +
                '}';
    }
}
