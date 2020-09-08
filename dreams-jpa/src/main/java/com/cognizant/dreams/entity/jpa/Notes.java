package com.cognizant.dreams.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Notes")
public class Notes  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notes_id")
    private long notesId;

    @Column(name = "notes")
    private String notes;

    @Column(name = "getNotes_id")
    private long getNotesId;

	@Column(name = "retrosession_id")
	private String retroSessionId;
    
	@Column(name = "retrosession_name")
    private String retroSessionName;

    @OneToMany(mappedBy = "notes", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Vote> voteList;

    @Column(name = "group_id")
    private long groupId;

    @Column(name = "group_name")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "created_user_id",referencedColumnName="id")
    private User user;

    @OneToMany(mappedBy = "notes", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Comment> commentList;

    
    @OneToMany(mappedBy = "notes", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Action> actionList;

    
    @Temporal(TemporalType.TIMESTAMP)
  	private Date created;
      
      @Temporal(TemporalType.TIMESTAMP)
  	private Date updated;
      
      @Column(name="created_by", length=50)
  	private String createdBy;
      
      @Column(name="modified_by", length=50)
  	private String modifiedBy;

      @Column(name = "completed")
      private boolean completed;

    @Override
    public String toString() {
        return "Notes{" +
                "notesId=" + notesId +
                ", notes='" + notes + '\'' +
                ", getNotesId=" + getNotesId +
                ", votes=" + voteList +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", user=" + user +
                ", commentList=" + commentList +
                ", actionList=" + actionList +
                ", retroSessionId='" + retroSessionId + '\'' +
                ", retroSessionName='" + retroSessionName + '\'' +
                '}';
    }
}
