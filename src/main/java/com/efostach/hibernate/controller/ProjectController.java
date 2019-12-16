package com.efostach.hibernate.controller;

import com.efostach.hibernate.model.Project;
import com.efostach.hibernate.model.ProjectStatus;
import com.efostach.hibernate.repository.io.ProjectRepoImpl;

import java.util.List;

public class ProjectController {

    private ProjectRepoImpl ioProject = new ProjectRepoImpl();

    public void createProject(String name, Integer cost) {
        Project project = new Project();

        project.setName(name);
        project.setCost(cost);
        project.setStatus(ProjectStatus.IN_PROGRESS);

        ioProject.create(project);
    }

    public void completeProject(Integer id) {
        Project project = ioProject.getById(id);
        project.setStatus(ProjectStatus.COMPLETED);
        ioProject.update(project);
    }

    public List<Project> showProjects() {

        return ioProject.getAll();
    }

    public List<Project> findProjectsByCost(Integer cost) {

        return ioProject.getByCost(cost);
    }

    public List<Project> findProjectsBySkill(Integer skill) {

        return ioProject.getBySkill(skill);
    }

    public List<Project> findProjectsByTeam(Integer teamId) {

        return ioProject.getByTeam(teamId);
    }
}
