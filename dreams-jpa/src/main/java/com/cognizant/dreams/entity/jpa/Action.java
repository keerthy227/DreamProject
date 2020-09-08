package com.cognizant.dreams.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="action")
public class Action implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "action_id")
	private long actionId;

	@Column(name = "action")
	private String action;

	@Column(name="due_date")
	public Date dueDate;

	@Column(name = "completed_date")
	public Date completedDate;

	@ManyToOne
	@JoinColumn(name = "action_user_id",referencedColumnName="id")
	private User actionUser;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "action_notes_id",referencedColumnName="notes_id")
	private Notes notes;

	@OneToMany(mappedBy = "action", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<ActionComments> actionCommentList;

	@Column(name= "retrosession_id")
	private String retroSessionId;

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
		return "Action{" +
				"actionId=" + actionId +
				", action='" + action + '\'' +
				", dueDate=" + dueDate +
				", actionUser=" + actionUser +
				", retroSessionId='" + retroSessionId + '\'' +
				", completedDate=" +completedDate +
				'}';
	}
}
