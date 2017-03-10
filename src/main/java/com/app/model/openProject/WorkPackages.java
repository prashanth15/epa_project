package com.app.model.openProject;

import javax.persistence.*;

/**
 * Created by K.Kokulan on 3/10/2017.
 */

@Entity
@Table(name="work_packages")
public class WorkPackages {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int type_id;
    private int assigned_to_id;
    private int project_id;
    private int status_id;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getAssigned_to_id() {
        return assigned_to_id;
    }

    public void setAssigned_to_id(int assigned_to_id) {
        this.assigned_to_id = assigned_to_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
