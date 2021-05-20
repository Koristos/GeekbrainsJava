package ru.geekbrains.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Product;
import ru.geekbrains.models.ProductPage;
import ru.geekbrains.repository.ProductRepo;


import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAllProducts (){
        return productRepo.findAll();
    }

    public Product addProduct (Product product){
        return productRepo.save(product);
    }

    public boolean deleteProductById (Integer id){
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return true;
        }else return false;
    }

    public ProductPage getPagedProducts(Integer curPage, Integer direction){
        if (curPage==null) {
            curPage=0;
            direction=0;
        }
        Pageable pageable = PageRequest.of(curPage, 5, Sort.Direction.fromString("ASC"), "name");
        Page<Product> products = productRepo.findAll(pageable);
        if (direction<0){
            products = productRepo.findAll(pageable.previousOrFirst());
        } else if (direction>0 && products.getTotalPages()>curPage){
            products = productRepo.findAll(pageable.next());
        }
        return new ProductPage(products.getContent(), products.getNumber(),0);
    }

}
