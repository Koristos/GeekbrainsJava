package ru.geekbrains.SpringLessonThree.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.SpringLessonThree.dto.Product;
import ru.geekbrains.SpringLessonThree.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/storage")
public class ProductListController {

    private final ProductService productService;

    @GetMapping
    @ModelAttribute("products")
    public List<Product> showHtml() {
        return productService.getAllProducts();
    }
}
