package ru.geekbrains.springlessonfour.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.springlessonfour.dto.Product;
import ru.geekbrains.springlessonfour.service.ProductService;

@Controller
@RequestMapping("/addform")
@RequiredArgsConstructor
public class ProductUploadController {

    private final ProductService productService;

    @GetMapping
    public String showAddForm(){
        return "addform";
    }

    @PostMapping
    public ModelAndView addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        ModelAndView model = new ModelAndView("redirect:" + "./info");
        model.addObject("message", "Product added successfully!");
        return model;
    }
}
