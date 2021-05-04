package ru.geekbrains.SpringLessonFive.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.SpringLessonFive.dto.Product;
import ru.geekbrains.SpringLessonFive.service.ProductService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public Model showInfo(Model model){
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products", products);
        return model;
    }

}
