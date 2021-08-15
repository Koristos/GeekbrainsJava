package ru.geekbrains.SpringLessonFive.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringLessonFive.dto.Product;
import ru.geekbrains.SpringLessonFive.service.ProductService;

@Controller
@RequestMapping("/details")
@RequiredArgsConstructor
public class DetailsController {
    @Autowired
    ProductService productService;
    @GetMapping
    public Model showDetails(@RequestParam Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return model;
    }

    @PostMapping
    public Model updateProduct(@RequestParam Long id, @ModelAttribute Product product, Model model){
        product.setId(id);
        productService.updateProduct(product);
        model.addAttribute("product", productService.getProductById(product.getId()));
        return model;
    }
    @DeleteMapping
    public String updateProduct(@RequestParam Long id){
        productService.deleteProduct(id);
        return "redirect:./";
    }
}
