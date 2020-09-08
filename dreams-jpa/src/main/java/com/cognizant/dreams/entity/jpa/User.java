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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "user_name")
    private String userName;



    @Column(name="display_name")
    private String displayName;

    @Column(name = "password")
    private String password;


    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Notes> notes;

    @JsonIgnore
    @OneToMany(mappedBy = "commentUser", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Comment> comments;


    @JsonIgnore
    @OneToMany(mappedBy = "actionUser", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Action> actions;

    @JsonIgnore
    @OneToMany(mappedBy = "actionCommentUser", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ActionComments> actionComments;

    @JsonIgnore
    @OneToMany(mappedBy = "actionAssignedUser", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ActionAssigned> actionAssigned;


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
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
