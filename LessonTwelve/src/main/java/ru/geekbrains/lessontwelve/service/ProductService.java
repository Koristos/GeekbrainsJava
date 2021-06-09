package ru.geekbrains.lessontwelve.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.lessontwelve.models.Product;
import ru.geekbrains.lessontwelve.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProductById (int id){
        return productRepository.findById(id).orElseThrow(()->new NoSuchElementException(
                String.format("No product with id %d found!", id)));
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
