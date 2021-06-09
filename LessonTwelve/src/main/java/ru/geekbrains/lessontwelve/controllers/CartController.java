package ru.geekbrains.lessontwelve.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lessontwelve.utils.Cart;

@RestController
@AllArgsConstructor
@RequestMapping ("/cart")
public class CartController {

    @GetMapping
    public Cart getCart (){
        return null;
    }

    @PutMapping ("/{id}")
    public boolean putProduct(@PathVariable(name = "id") Integer id){

        return false;
    }

    @DeleteMapping("/{id}")
    public boolean removeProduct (@PathVariable(name = "id") Integer id){
        return false;
    }

    @PostMapping
    public boolean saveCartAsNewOrder (){
        return false;
    }
}
