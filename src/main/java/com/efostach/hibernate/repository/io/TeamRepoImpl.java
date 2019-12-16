package com.efostach.hibernate.repository.io;

import com.efostach.hibernate.model.Team;
import com.efostach.hibernate.repository.TeamRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.efostach.hibernate.repository.io.HibernateUtil.getSessionFactory;

public class TeamRepoImpl implements TeamRepository {

    public Team getById(Integer id){
        Session session = getSessionFactory().openSession();
        Team team = session.get(Team.class, id);

        session.close();
        return team;
    }

    public List<Team> getBySkill(Integer skillId) {
        Session session = getSessionFactory().openSession();
        List teams =  session.createQuery("FROM teams t WHERE t.skill_id = " + skillId).list();

        session.close();
        return teams;
    }

    public List<Team> getAll() {
        Session session = getSessionFactory().openSession();
        List teams = session.createQuery("FROM teams").list();

        session.close();
        return teams;
    }

    public void create(Team team){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(team);
        transaction.commit();
        session.close();
    }

    public void update(Team team) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(team);
        transaction.commit();
        session.close();
    }

    public void delete(Team team) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(team);
        transaction.commit();
        session.close();
    }
}
