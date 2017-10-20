package com.locus.role_system.data.entity;

import javax.persistence.*;
import java.util.List;

@Table(name="resource")
@Entity
public class Resource {

    @Id
    @Column(name = "resource_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resourceId;
    @Column(name="resource_name", nullable = false, length = 20)
    private String resourceName;

    public Resource() {
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
