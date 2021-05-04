package ru.geekbrains.springlessonfour.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.springlessonfour.dto.Product;
import ru.geekbrains.springlessonfour.dao.ProductDao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao storage;

    public void addProduct (Product product){
        storage.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return storage.getAllProducts();
    }

    public Product getProductById (Integer id){
        return storage.getProductById(id);
    }

    public List<Product> getManyProducts (Integer ... id) {
        List<Product> result = new CopyOnWriteArrayList<>();
        for (Integer a: id) {
            result.add(storage.getProductById(a));
        }
        return result;
    }

}
