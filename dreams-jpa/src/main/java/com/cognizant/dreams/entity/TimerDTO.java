package com.cognizant.dreams.entity;


import lombok.Data;

import java.io.Serializable;


@Data
public class TimerDTO implements Serializable {

    Long id;

    Long min;

    String setTime;

    String sessionId;

    @Override
    public String toString() {
        return "TimerDTO{" +
                "id=" + id +
                ", min=" + min +
                ", setTime='" + setTime + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
