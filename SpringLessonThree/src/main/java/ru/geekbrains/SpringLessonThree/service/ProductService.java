package ru.geekbrains.SpringLessonThree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.SpringLessonThree.dto.Product;
import ru.geekbrains.SpringLessonThree.repository.ProductRepository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository storage;

    public void addProduct (Product product){
        product.setId(UUID.randomUUID());
        storage.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return storage.getAllProducts();
    }

    public Product getProductById (UUID id){
        return storage.getProductById(id);
    }

    public List<Product> getManyProducts (UUID ... id) {
        List<Product> result = new CopyOnWriteArrayList<>();
        for (UUID a: id) {
            result.add(storage.getProductById(a));
        }
        return result;
    }

}
