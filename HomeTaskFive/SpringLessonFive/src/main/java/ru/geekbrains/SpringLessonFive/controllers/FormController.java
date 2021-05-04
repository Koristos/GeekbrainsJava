package ru.geekbrains.SpringLessonFive.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.SpringLessonFive.dto.Product;
import ru.geekbrains.SpringLessonFive.service.ProductService;

@Controller
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {

    @Autowired
    ProductService productService;

    @GetMapping
    public String showForm(){
        return "form";
    }

    @PostMapping
    public String addProduct(@ModelAttribute Product product){
        productService.addProduct(product);
        return "redirect:./";
    }
}
