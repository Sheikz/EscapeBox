package com.escape.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Sheikz on 8/15/2016.
 */
public class EscapeDBSessionFactory
{
    private static final SessionFactory sessionFactory = new Configuration().configure()
            .buildSessionFactory();

    public static Session getSession()
    {
        return sessionFactory.openSession();
    }
}
