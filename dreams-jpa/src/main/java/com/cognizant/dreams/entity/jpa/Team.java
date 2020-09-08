package com.cognizant.dreams.entity.jpa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private long id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "user_id")
    private Long userId;

    @Column(name="role")
    private String role;
    @Column(name="user_name")
    private String userName;
    @Column(name="display_name")
    private String displayName;

    @JsonIgnore
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<RetroSession> retroSessions;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", userId=" + userId +
                ", role='" + role + '\'' +
                ", userName='" + userName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", retroSessions=" + retroSessions +
                '}';
    }
}
