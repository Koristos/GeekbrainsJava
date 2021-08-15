package ru.geekbrains.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.models.Product;
import ru.geekbrains.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public Page<Product> findAll (@RequestParam (required = false, name = "categoryId") Integer categoryId,
                                  @RequestParam (name = "curPage", defaultValue = "1") Integer curPage,
                                  @RequestParam (name = "pageLength", defaultValue = "2") Integer pageLength){
        return productService.findAllProducts(categoryId, curPage, pageLength);
    }

    @GetMapping("/{id}")
    public Product findByid (int id){
        return productService.findProductById(id);
    }

    @PutMapping
    public Product updateProduct (@RequestParam Product product){
        return productService.addProduct(product);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        System.out.println(product.toString());
        return productService.addProduct(product);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProductById(@PathVariable int id){
        System.out.println(id);
        return productService.deleteProductById(id);
    }

}
