package com.efostach.hibernate.controller;

import com.efostach.hibernate.model.Team;
import com.efostach.hibernate.repository.hibernate.TeamRepoImpl;

import java.util.List;

public class TeamController {

    private TeamRepoImpl ioTeam = new TeamRepoImpl();

    public List<Team> showTeams() {

        return ioTeam.getAll();
    }

    public List<Team> getTeamsBySkill(Integer skillId) {

        return ioTeam.getBySkill(skillId);
    }
}
