package com.locus.role_system.data.entity;

import javax.persistence.*;
import java.util.List;

@Table(name="domain_user")
@Entity
public class User {
    @Id
    @Column(name = "user_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name="username", nullable = false, length = 20)
    private String username;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
