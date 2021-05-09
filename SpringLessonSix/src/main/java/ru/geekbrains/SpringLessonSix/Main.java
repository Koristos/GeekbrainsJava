package ru.geekbrains.SpringLessonSix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.SpringLessonSix.config.AppConfig;
import ru.geekbrains.SpringLessonSix.input.Console;

/**
 * Possible commands:
 * - product product_id (id=1-5)
 * returns all info about product, including actual price and a list of Persons, who had ever bought it.
 * - person person_id (id=4-9)
 * returns all info about person, including it'spersonal data anda list od Products, that were ordered by the Person
 * with price, actual at the moment of purchase
 */


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean("userApp", Console.class).start();

    }
}
