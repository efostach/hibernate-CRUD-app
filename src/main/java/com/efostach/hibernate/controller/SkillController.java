package com.efostach.hibernate.controller;

import com.efostach.hibernate.model.Skill;
import com.efostach.hibernate.repository.io.SkillRepoImpl;

import java.util.List;

public class SkillController {

    private SkillRepoImpl ioSkill = new SkillRepoImpl();

    public List<Skill> showSkills() {

        return ioSkill.getAll();
    }
}
