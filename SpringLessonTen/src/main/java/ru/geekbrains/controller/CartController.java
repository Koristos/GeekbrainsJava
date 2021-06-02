package ru.geekbrains.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dto.Cart;
import ru.geekbrains.models.Product;
import ru.geekbrains.service.CartService;
import ru.geekbrains.util.ProductStack;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    @Autowired
    private final CartService cartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Cart findAll (){
        System.out.println(cartService.getCart());
        return cartService.getCart();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean saveOrder (){
        return cartService.saveOrder();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addProduct(@RequestBody Product product){
        return cartService.putProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProductById(@PathVariable int id){
        return cartService.removeProductById(id);
    }

}