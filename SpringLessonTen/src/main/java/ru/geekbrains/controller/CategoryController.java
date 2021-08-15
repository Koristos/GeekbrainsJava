package ru.geekbrains.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.models.Category;
import ru.geekbrains.models.Product;
import ru.geekbrains.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping
    public List<Category> findAll (){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findByid (int id){
        return categoryService.findCategoryById(id);
    }

    @PutMapping
    public Category updateCategory (@RequestParam Category category){
        return categoryService.addCategory(category);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        category.setProducts(new ArrayList<Product>());
        return categoryService.addCategory(category);
    }

    @DeleteMapping ("/{id}")
    public boolean deleteCategoryById (@RequestParam Integer id){
        return categoryService.deleteById(id);
    }

}
