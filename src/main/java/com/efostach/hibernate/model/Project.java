package com.efostach.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "status")
    private ProjectStatus status;

    public Project() {
    }

    public Project(Integer id, String name, Integer cost, ProjectStatus status) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(name).append(",")
                .append(cost).append(",")
                .append(status)
                .append("\n").toString();
    }
}
