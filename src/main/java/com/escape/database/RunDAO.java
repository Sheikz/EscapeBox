package com.escape.database;

import com.escape.model.Run;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Sheikz on 8/20/2016.
 */
@Repository
public class RunDAO
{
    private static final Logger logger = Logger.getLogger("RunDAO");

    public static List<Run> getRuns()
    {
        List<Run> result;

        Session session = EscapeDBSessionFactory.getSession();

        result = session.createQuery("from Run").list();
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

    public static void deleteRun(int id)
    {
        Session session = EscapeDBSessionFactory.getSession();

        try {
            Transaction tx = session.beginTransaction();
            Run r = session.get(Run.class, id);
            session.delete(r);
            tx.commit();
        }
        finally{
            session.close();
        }
        return;
    }
}
