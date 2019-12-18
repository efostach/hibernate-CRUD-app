package com.efostach.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "cost")
    private Integer cost;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="status", nullable = false)
    private ProjectStatus status;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable (name="customer_projects",
            joinColumns=@JoinColumn (name="project_id"),
            inverseJoinColumns=@JoinColumn(name="customer_id"))
    private List<Customer> customers;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable (name="project_teams",
            joinColumns=@JoinColumn (name="project_id"),
            inverseJoinColumns=@JoinColumn(name="team_id"))
    private List<Team> teams;

    public Project() {
    }

    public Project(Integer id, String name, Integer cost, ProjectStatus status, List<Customer> customers, List<Team> teams) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.status = status;
        this.customers = customers;
        this.teams = teams;
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> teams) {
        this.customers = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
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
