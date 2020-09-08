package com.cognizant.dreams.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "action_assigned")
public class ActionAssigned implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
   
    @Column(name = "action_id")
    private long actionId;

    @Column(name = "retro_session_id")
    public String retroSessionId;

    @ManyToOne
    @JoinColumn(name = "action_assigned_user_id", referencedColumnName = "id")
    private User actionAssignedUser;
    
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
        return "ActionAssigned{" +
                "id=" + id +
                ", actionId=" + actionId +
                ", retroSessionId='" + retroSessionId + '\'' +
                ", actionAssignedUser=" + actionAssignedUser +
                '}';
    }
}
