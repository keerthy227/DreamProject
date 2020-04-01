package com.cognizant.userdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "user")
@Entity
//@Document(collection = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "contactnumber")
    private String contactnumber;

    @Column(name = "password")
    private String password;

    @Column(name = "dateofbirth")
    private Date dateofbirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "role")
    private String role;

}