package com.cognizant.authenticationservice.entity;

import java.util.List;

import lombok.Data;

@Data
public class TemplateDTO {
    public long id;
    public String templateName;
    public long noOfColumns;
    public List<String> topics;

    public List<String> icons;

    private List<SessionDTO> sessionList;

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", templateName='" + templateName + '\'' +
                ", noOfColumns=" + noOfColumns +
                '}';
    }
}
