package ru.geekbrains.SpringLessonSix.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@NoArgsConstructor
@Data
public class DaoConfig {
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init(){
        sessionFactory =new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
