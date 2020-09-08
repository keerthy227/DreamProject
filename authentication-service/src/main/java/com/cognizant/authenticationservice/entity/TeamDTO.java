package com.cognizant.authenticationservice.entity;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
public class TeamDTO implements Serializable {

    public long id;

    public String teamName;

    public Long userId;

    public String role;
}