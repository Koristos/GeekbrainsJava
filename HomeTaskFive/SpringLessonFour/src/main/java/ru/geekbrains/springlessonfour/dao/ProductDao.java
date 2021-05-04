package ru.geekbrains.springlessonfour.dao;


import org.springframework.stereotype.Repository;
import ru.geekbrains.springlessonfour.dto.Product;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    public List<Product> getAllProducts() {
        return entityManager
                .createQuery("from Product p order by p.name", Product.class).getResultList();
    }

    public Product getProductById (Integer id){
        return entityManager.find(Product.class,id);
    }
}
