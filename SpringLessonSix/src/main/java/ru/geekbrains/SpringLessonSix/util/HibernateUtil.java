package ru.geekbrains.SpringLessonSix.util;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.geekbrains.SpringLessonSix.config.DaoConfig;
import ru.geekbrains.SpringLessonSix.dto.Person;

import java.sql.SQLException;


@NoArgsConstructor
public class HibernateUtil {

    public static <T> T executeTransaction (SessionFactory sessionFactory, HibernateAcction<T> acction){
        Session session = sessionFactory.getCurrentSession();
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            T result = acction.perform(session);
            session.getTransaction().commit();
            return result;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException("SWW during transacrion.");
        }
    }
}
