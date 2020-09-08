package com.cognizant.dreams.entity.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment")
public class Comment implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comment_id")
	private long commentId;

	@Column(name = "comment")
	private String comment;

	@ManyToOne
	@JoinColumn(name = "comment_notes_id",referencedColumnName="notes_id")
	@JsonIgnore
	private Notes notes;

	@ManyToOne
	@JoinColumn(name = "comment_user_id",referencedColumnName="id")
	private User commentUser;


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
		return "Comment{" +
				"commentId=" + commentId +
				", comment='" + comment + '\'' +
				", commentUser=" + commentUser +
				'}';
	}
}
