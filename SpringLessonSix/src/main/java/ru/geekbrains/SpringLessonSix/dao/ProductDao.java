package ru.geekbrains.SpringLessonSix.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringLessonSix.config.DaoConfig;
import ru.geekbrains.SpringLessonSix.dto.Product;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private DaoConfig daoConfig;

    public List<Product> getProductsById (int idToSerach){
        Session session = daoConfig.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Product WHERE id_products=:inputId");
            query.setParameter("inputId", idToSerach);
            List<Product> productList = query.getResultList();
            session.getTransaction().commit();
            return productList;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException("SWW during transaction");
        }

    }

}
