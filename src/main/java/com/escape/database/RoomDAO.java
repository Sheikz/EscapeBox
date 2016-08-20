package com.escape.database;

import com.escape.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Sheikz on 8/20/2016.
 */
@Repository
public class RoomDAO
{
    private static final Logger logger = Logger.getLogger("RoomDAO");

    public static int addRoom(Room r)
    {
        Session session = EscapeDBSessionFactory.getSession();
        try {
            Transaction tx = session.beginTransaction();
            session.persist(r);
            tx.commit();
        }
        finally
        {
            session.close();
        }

        return r.getId();
    }

    public static List<Room> getRooms()
    {
        List<Room> result;

        Session session = EscapeDBSessionFactory.getSession();

        result = session.createQuery("from Room").list();
        session.close();
        return result;
    }

    public static Room getRoom(int id)
    {
        Session session = EscapeDBSessionFactory.getSession();
        Room result = session.get(Room.class, id);
        session.close();
        return result;
    }

    public static void deleteRoom(int id)
    {
        Session session = EscapeDBSessionFactory.getSession();

        try {
            Transaction tx = session.beginTransaction();
            Room r = session.get(Room.class, id);
            session.delete(r);
            tx.commit();
        }
        finally{
            session.close();
        }
        return;
    }
}
