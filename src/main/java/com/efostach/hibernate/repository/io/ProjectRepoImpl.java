package com.efostach.hibernate.repository.io;

import com.efostach.hibernate.model.Project;
import com.efostach.hibernate.repository.ProjectRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.efostach.hibernate.repository.io.HibernateUtil.getSessionFactory;

public class ProjectRepoImpl implements ProjectRepository {

    public Project getById(Integer id){
        Session session = getSessionFactory().openSession();
        Project project = session.get(Project.class, id);

        session.close();
        return project;
    }

    public List<Project> getByTeam(Integer teamId) {
        Session session = getSessionFactory().openSession();
        List projects =  session.createQuery("FROM projects p WHERE p.team_id = " + teamId).list();

        session.close();
        return projects;
    }

    public List<Project> getBySkill(Integer skillId) {
        Session session = getSessionFactory().openSession();
        List projects =  session.createQuery("FROM projects p WHERE p.skill_id = " + skillId).list();

        session.close();
        return projects;
    }

    public List<Project> getByCost(Integer cost) {
        Session session = getSessionFactory().openSession();
        List projects =  session.createQuery("FROM projects p WHERE p.cost = " + cost).list();

        session.close();
        return projects;
    }

    public List<Project> getAll() {
        Session session = getSessionFactory().openSession();
        List projects = session.createQuery("FROM projects").list();

        session.close();
        return projects;
    }

    public void create(Project project){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(project);
        transaction.commit();
        session.close();
    }

    public void update(Project project) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(project);
        transaction.commit();
        session.close();
    }

    public void delete(Project project) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(project);
        transaction.commit();
        session.close();
    }
}
