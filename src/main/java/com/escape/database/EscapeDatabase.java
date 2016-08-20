package com.escape.database;

import com.escape.model.Run;
import com.escape.model.Scenario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Sheikz on 8/15/2016.
 */
@Repository
public class EscapeDatabase {

    private static final Logger logger = Logger.getLogger("EscapeDatabase");

    @PersistenceContext
    private static EntityManager em;

    public static int addScenario(Scenario r)
    {
        Session session = EscapeDBSessionFactory.getSession();
        try {
            Transaction tx = session.beginTransaction();
            session.persist(r);
            tx.commit();
        }
        finally{
            session.close();
        }

        return r.getId();
    }

    public static List<Scenario> getScenarios()
    {
        List<Scenario> result;

        Session session = EscapeDBSessionFactory.getSession();

        result = session.createQuery("from Scenario").list();
        session.close();
        return result;
    }

    public static List<Run> getRuns()
    {
        List<Run> result;

        Session session = EscapeDBSessionFactory.getSession();

        result = session.createQuery("from Run").list();
        session.close();
        return result;
    }

    public static Scenario getScenario(int id)
    {
        Session session = EscapeDBSessionFactory.getSession();
        Scenario result = session.get(Scenario.class, id);
        session.close();
        return result;
    }

    public static Run getRun(int id)
    {
        Session session = EscapeDBSessionFactory.getSession();
        Run result = session.get(Run.class, id);
        session.close();
        return result;
    }

    public static void deleteScenario(int id)
    {
        Session session = EscapeDBSessionFactory.getSession();

        try {
            Transaction tx = session.beginTransaction();
            Scenario r = session.get(Scenario.class, id);
            session.delete(r);
            tx.commit();
        }
        finally{
            session.close();
        }
        return;
    }

    public static int addRun(Run run)
    {
        Session session = EscapeDBSessionFactory.getSession();
        try {
            Transaction tx = session.beginTransaction();
            session.persist(run);
            tx.commit();
        }
        finally {
            session.close();
        }
        return run.getId();
    }
}
