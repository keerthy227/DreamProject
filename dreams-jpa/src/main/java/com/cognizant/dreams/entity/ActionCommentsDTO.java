package com.cognizant.dreams.entity;

import com.cognizant.dreams.entity.jpa.Action;
import com.cognizant.dreams.entity.jpa.User;
import lombok.Data;

@Data
public class ActionCommentsDTO {

    private long actionCommentId;

    private String comments;

    private User actionCommentUser;

    private Action action;

    private String retroSessionId;

    @Override
    public String toString() {
        return "ActionCommentsDTO{" +
                "actionCommentId=" + actionCommentId +
                ", comments='" + comments + '\'' +
                ", actionCommentUser=" + actionCommentUser +
                ", action=" + action +
                ", retroSessionId='" + retroSessionId + '\'' +
                '}';
    }

    public static class StatusCheckDTO {
    }
}
