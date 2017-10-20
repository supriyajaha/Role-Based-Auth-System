package com.locus.role_system.data.entity;

import javax.persistence.*;
import java.util.List;

@Table(name="role")
@Entity
public class Role {
    @Id
    @Column(name = "role_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    @Column(name="role_name", nullable = false, length = 20)
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_action_type", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = { @JoinColumn(name = "action_type_id") })
    private List<ActionType> actionTypes;

    public Role() {
    }

    public List<ActionType> getActionTypes() {
        return actionTypes;
    }

    public void setActionTypes(List<ActionType> actionTypes) {
        this.actionTypes = actionTypes;
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
