package com.efostach.hibernate.model;

import javax.persistence.*;

@Entity
@Table (name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    private Team() {
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

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(name)
                .append("\n").toString();
    }
}
