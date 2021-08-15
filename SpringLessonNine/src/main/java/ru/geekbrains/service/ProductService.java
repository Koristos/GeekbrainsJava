package ru.geekbrains.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Product;
import ru.geekbrains.repository.ProductRepo;
import ru.geekbrains.service.specifications.ProductSpec;


import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Data
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Page<Product> findAllProducts(Integer categoryId, int curPage, int pageLength) {
        if (categoryId != null) {
            Specification<Product> specification = ProductSpec.categoryBound(categoryId);
            return productRepo.findAll(specification, PageRequest.of(curPage - 1, pageLength));
        }
        return productRepo.findAll(PageRequest.of(curPage - 1, pageLength));
    }

    public Product findProductById(int id) {
        return productRepo.findById(id).orElseThrow(() -> new NoSuchElementException(
                String.format("Product with id = %d not found", id)));
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public boolean deleteProductById(Integer id) {
        productRepo.deleteById(id);
        return (!productRepo.existsById(id));
    }

}
