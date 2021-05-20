package ru.geekbrains.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.models.Product;
import ru.geekbrains.models.ProductPage;
import ru.geekbrains.service.ProductService;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping
    public boolean deleteProductById (@RequestParam Integer id){
        return productService.deleteProductById(id);
    }
    @GetMapping
    public ProductPage getPagedProducts (
            @RequestParam (required = false) Integer curPage,
            @RequestParam (required = false) Integer direction){
        return productService.getPagedProducts(curPage, direction);
    }

}
