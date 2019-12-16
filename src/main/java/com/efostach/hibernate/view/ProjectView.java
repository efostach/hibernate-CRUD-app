package com.efostach.hibernate.view;

import com.efostach.hibernate.controller.ProjectController;
import com.efostach.hibernate.model.Project;

class ProjectView {

    private ProjectController projectController = new ProjectController();

    void showProjects() {
        for (Project object : projectController.showProjects()) {
            print(object);
        }
    }

    void createProject(String name, Integer cost) {
        projectController.createProject(name, cost);
    }

    void completeProject(Integer projectId) {
        projectController.completeProject(projectId);
    }

    void showProjectsFilteredByCost(Integer cost) {
        for (Project object : projectController.findProjectsByCost(cost)) {
            print(object);
        }
    }

    void showProjectsFilteredBySkill(Integer skillId) {
        for (Project object : projectController.findProjectsBySkill(skillId)) {
            print(object);
        }
    }

    void showProjectsFilteredByTeam(Integer teamId) {
        for (Project object : projectController.findProjectsByTeam(teamId)) {
            print(object);
        }
    }

    private void print(Project project) {
        System.out.println("ID: " + project.getId()
                + "\tName: " + project.getName()
                + "\tCost: " + project.getCost()
                + "\tStatus: " + project.getStatus());
    }
}
