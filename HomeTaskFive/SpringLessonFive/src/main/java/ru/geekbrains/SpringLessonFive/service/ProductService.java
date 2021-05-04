package ru.geekbrains.SpringLessonFive.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.SpringLessonFive.dao.ProductDao;
import ru.geekbrains.SpringLessonFive.dto.Product;

import java.util.List;

@Service
@NoArgsConstructor
@Data
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public void addProduct(Product product){
        productDao.addProduct(product);
    }

    public void updateProduct(Product updatedProduct){
        productDao.updateProduct(updatedProduct);
    }

    public void deleteProduct(Long id){
        productDao.deleteProduct(id);
    }

    public Product getProductById(Long id){
        return productDao.getProductById(id);
    }

    public List<Product> getAllProducts (){
        return productDao.getAllProducts();
    }
}
