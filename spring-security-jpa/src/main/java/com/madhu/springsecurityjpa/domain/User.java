package com.madhu.springsecurityjpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "active")
    private boolean active;

    @Column(name = "roles")
    private String roles;

    @Column(name = "password")
    private String pwd;

    @Column(name = "user_name")
    private String userName;

}
