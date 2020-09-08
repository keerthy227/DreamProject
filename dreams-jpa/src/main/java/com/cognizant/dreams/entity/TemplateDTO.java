package com.cognizant.dreams.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Data
public class TemplateDTO implements Serializable{
	private long id;
  
	private String templateName;
  
	private long noOfColumns;

	private List topics;

	private List icons;

	@JsonIgnore
    private List<SessionDTO> retroSessionList;

	@Override
	public String toString() {
		return "TemplateDTO{" +
				"id=" + id +
				", templateName='" + templateName + '\'' +
				", noOfColumns=" + noOfColumns +
				", topics=" + topics +
				", icons=" + icons +
				'}';
	}
}
