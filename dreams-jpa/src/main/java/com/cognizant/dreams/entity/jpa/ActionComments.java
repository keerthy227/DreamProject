package com.cognizant.dreams.entity.jpa;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="action_comments")
public class ActionComments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "action_comment_id")
    private long actionCommentId;

    @Column(name = "action_comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "action_comment_user_id",referencedColumnName="id")
    private User actionCommentUser;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "action_id",referencedColumnName="action_id")
    private Action action;

    @Column(name= "retrosession_id")
    private String retroSessionId;

    @Override
    public String toString() {
        return "ActionComments{" +
                "actionCommentId=" + actionCommentId +
                ", comments='" + comments + '\'' +
                ", actionCommentUser=" + actionCommentUser +
                ", action=" + action +
                ", retroSessionId=" + retroSessionId +
                '}';
    }
}
