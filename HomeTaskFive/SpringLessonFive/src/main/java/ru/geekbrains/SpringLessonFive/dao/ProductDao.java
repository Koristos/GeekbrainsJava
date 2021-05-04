package ru.geekbrains.SpringLessonFive.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringLessonFive.dto.Product;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProductDao {


    private static Long idIter = 0L;
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init(){
        sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public void addProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }catch (RuntimeException e){
            rollback(session);
            throw e;
        }

    }

    public void updateProduct(Product updatedProduct){
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(updatedProduct);
            session.getTransaction().commit();
        }catch (RuntimeException e){
            rollback(session);
            throw e;
        }
    }

    public void deleteProduct(Long id){
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Product product=session.get(Product.class,id);
            session.delete(product);
            session.getTransaction().commit();
        }catch (RuntimeException e){
            rollback(session);
            throw e;
        }
    }

    public Product getProductById(Long id){
        Session session = sessionFactory.getCurrentSession();
        Product product;
        try {
            session.beginTransaction();
            product=session.get(Product.class,id);
            session.getTransaction().commit();
        }catch (RuntimeException e){
            rollback(session);
            throw e;
        }
        return product;
    }

    public List<Product> getAllProducts (){
        Session session = sessionFactory.getCurrentSession();
       List<Product> products;
        try {
            session.beginTransaction();
            products=session.createQuery("FROM Product").getResultList();
            session.getTransaction().commit();
        }catch (RuntimeException e){
            rollback(session);
            throw e;
        }
        return products;
    }

    private void rollback(Session session){
        session.getTransaction().rollback();
    }
}
