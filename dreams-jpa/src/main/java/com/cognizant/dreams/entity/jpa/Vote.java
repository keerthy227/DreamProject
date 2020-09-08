package com.cognizant.dreams.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Vote")
public class Vote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long voteId;

    @Column(name = "votes")
    private Long votes;

    @ManyToOne
    @JoinColumn(name = "vote_notes_id",referencedColumnName="notes_id")
    @JsonIgnore
    private Notes notes;

    @Column(name = "user_id")
    private Long userId ;

    @Column(name = "session_id")
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
        return "Vote{" +
                "voteId=" + voteId +
                ", votes=" + votes +
                ", userId=" + userId +
                ", retroSessionId='" + retroSessionId + '\'' +
                '}';
    }
}
