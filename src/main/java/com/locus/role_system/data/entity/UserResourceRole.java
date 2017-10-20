package com.locus.role_system.data.entity;

import javax.persistence.*;

@Table(name = "user_role_resource")
@Entity
public class UserResourceRole {
    @Id
    @Column(name = "user_role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_role_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    private Resource resource;


    public UserResourceRole() {
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
