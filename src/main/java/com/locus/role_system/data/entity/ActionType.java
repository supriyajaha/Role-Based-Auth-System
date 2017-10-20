package com.locus.role_system.data.entity;

import javax.persistence.*;
import java.util.List;

@Table(name="action_type")
@Entity
public class ActionType {
    @Id
    @Column(name = "action_type_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int actionTypeId;
    @Column(name="action_type_name", nullable = false, length = 20)
    private String actionTypeName;


    public ActionType() {
    }

    public int getActionTypeId() {
        return actionTypeId;
    }

    public void setActionTypeId(int actionTypeId) {
        this.actionTypeId = actionTypeId;
    }

    public String getActionTypeName() {
        return actionTypeName;
    }

    public void setActionTypeName(String actionTypeName) {
        this.actionTypeName = actionTypeName;
    }
}
