package ru.geekbrains.springlessonfour.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.springlessonfour.dto.Product;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ProductRepository {

    private final static List <Product> storage = new CopyOnWriteArrayList<Product>();

    static {
        storage.add(new Product(UUID.randomUUID(),"Banana","Banana description",2.5));
        storage.add(new Product(UUID.randomUUID(),"Apple","Apple description",3.5));
        storage.add(new Product(UUID.randomUUID(),"Orange","Orange description",2.2));
        storage.add(new Product(UUID.randomUUID(),"Grape","Grape description",1.8));
        storage.add(new Product(UUID.randomUUID(),"Plum","Plum description",2.8));
        storage.add(new Product(UUID.randomUUID(),"Pineapple","Pineapple description",3.1));
    }

    public void addProduct(Product product) {
        storage.add(product);
    }

    public List<Product> getAllProducts() {
        return storage;
    }

    public Product getProductById (UUID id){
        Product result = null;
        for (Product p: storage) {
            if (p.getId().equals(id)){
                result=p;
                break;
            }
        }
        return result;
    }
}
