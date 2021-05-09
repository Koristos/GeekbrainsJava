package ru.geekbrains.SpringLessonSix.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringLessonSix.config.DaoConfig;
import ru.geekbrains.SpringLessonSix.dto.Person;
import ru.geekbrains.SpringLessonSix.util.HibernateUtil;


@Repository
public class PersonDao {

    @Autowired
    private DaoConfig daoConfig;

    public Person getPerson (int id){
        return HibernateUtil.executeTransaction(daoConfig.getSessionFactory(),t->t.get(Person.class, id));
    }
}
