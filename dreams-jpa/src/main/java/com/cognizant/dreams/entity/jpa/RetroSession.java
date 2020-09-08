package com.cognizant.dreams.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RetroSession")
public class RetroSession implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="retroses_id")
    private long id;

    @Column(name="role")
    private String role;

    @Column(name="retrosession_id")
    private String retroSessionId;

    @Column(name="retrosession_name")
    private String retroSessionName;

    @Column(name="user_id")
    private long userId;

    @Column(name="user_name")
    private String userName;

    @Column(name = "date")
    private Date sessionDate;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "retrosession_template_id",referencedColumnName="id")
    private Template template;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "team",referencedColumnName="team_id")
    private Team team;

    @Override
    public String toString() {
        return "RetroSession{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", retroSessionId='" + retroSessionId + '\'' +
                ", retroSessionName='" + retroSessionName + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sessionDate=" + sessionDate +
                ", teamName='" + teamName + '\'' +
                ", status=" + status +
                ", template=" + template +

                '}';
    }
}
