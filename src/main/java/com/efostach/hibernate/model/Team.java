package com.efostach.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToMany
    @JoinTable (name="project_teams",
            joinColumns=@JoinColumn (name="team_id"),
            inverseJoinColumns=@JoinColumn(name="project_id"))
    private List<Project> projects;

    private Team() {
    }

    public Team(Integer id, String name, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(name)
                .append("\n").toString();
    }
}
