package ru.geekbrains.SpringLessonSix.util;

import org.hibernate.Session;

@FunctionalInterface
public interface HibernateAcction <T> {
    T perform (Session session);
}
