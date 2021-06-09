package ru.geekbrains.lessontwelve.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lessontwelve.models.Product;
import ru.geekbrains.lessontwelve.utils.Cart;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping ("/products")
public class ProductController {

    @GetMapping
    public List<Product> getProducts (){
        return null;
    }

    @PutMapping
    public boolean updateProduct(@RequestBody Product product){

        return false;
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct (@PathVariable(name = "id") Integer id){
        return false;
    }

    @PostMapping
    public boolean addProduct (@RequestBody Product product){
        return false;
    }
}
