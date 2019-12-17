package com.efostach.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "work_experience")
    private Integer workExperience;
    @Column(name = "team_id")
    private Integer teamId;
    @ManyToMany
    @JoinTable (name="employee_skills",
            joinColumns=@JoinColumn (name="employee_id"),
            inverseJoinColumns=@JoinColumn(name="skill_id"))
    private List<Skill> skills;

    private Employee() {
    }

    public Employee(Integer id, String firstName, String lastName, Integer workExperience, Integer teamId, List<Skill> skills) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.workExperience = workExperience;
        this.teamId = teamId;
        this.skills = skills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getWorkEcperience() {
        return workExperience;
    }

    public void setWorkEcperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(firstName).append(",")
                .append(lastName).append(",")
                .append(workExperience).append(",")
                .append(teamId)
                .append("\n").toString();
    }
}
