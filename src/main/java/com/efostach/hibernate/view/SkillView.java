package com.efostach.hibernate.view;

import com.efostach.hibernate.controller.SkillController;
import com.efostach.hibernate.model.Skill;

class SkillView {

    private SkillController skillController = new SkillController();

    void showSkills() {
        for (Skill object : skillController.showSkills()) {
            print(object);
        }
    }

    private void print(Skill skill) {
        System.out.println("ID: " + skill.getId()
                + "\tName: " + skill.getName());
    }
}
