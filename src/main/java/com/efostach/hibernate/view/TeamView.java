package com.efostach.hibernate.view;

import com.efostach.hibernate.controller.TeamController;
import com.efostach.hibernate.model.Team;

class TeamView {

    private TeamController teamController = new TeamController();

    void showTeams() {
        for (Team object : teamController.showTeams()) {
            print(object);
        }
    }

    void showFilteredTeamsBySkill(Integer skillId) {
        for (Team object : teamController.getTeamsBySkill(skillId)) {
            print(object);
        }
    }

    private void print(Team team) {
        System.out.println("ID: " + team.getId()
                + "\tName: " + team.getName());
    }
}
