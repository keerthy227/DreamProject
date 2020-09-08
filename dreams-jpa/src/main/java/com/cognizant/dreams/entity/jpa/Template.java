package com.cognizant.dreams.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Template")
public class Template implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name="template_name")
    private String templateName;
    
    @Column(name="no_of_columns")
    private long noOfColumns;

    @Column(name="topics")
    @ElementCollection(targetClass = String.class)
    private List topics;

    @Column(name="icons")
    @ElementCollection(targetClass = String.class )
    private List icons;

    @JsonIgnore
    @OneToMany(mappedBy = "template", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<RetroSession> retroSessionList;
    
    @Temporal(TemporalType.TIMESTAMP)
  	private Date created;
      
      @Temporal(TemporalType.TIMESTAMP)
  	private Date updated;
      
      @Column(name="created_by", length=50)
  	private String createdBy;
      
      @Column(name="modified_by", length=50)
  	private String modifiedBy;

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", templateName='" + templateName + '\'' +
                ", noOfColumns=" + noOfColumns +
                ", topics=" + topics +
                ", icons=" + icons +
                '}';
    }
}
