package com.locus.role_system.data.entity;

import javax.persistence.*;

@Table(name = "user_role_resource")
@Entity
public class UserResourceRole {
    @Id
    @Column(name = "user_role_resource_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userRoleResourceId;
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

    public int getUserRoleResourceId() {
        return userRoleResourceId;
    }

    public void setUserRoleResourceId(int userRoleResourceId) {
        this.userRoleResourceId = userRoleResourceId;
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
