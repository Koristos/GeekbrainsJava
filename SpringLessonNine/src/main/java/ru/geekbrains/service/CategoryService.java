package ru.geekbrains.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Category;
import ru.geekbrains.repository.CategoryRepo;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Data
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    @Lazy
    private ProductService productService;

    public Category findCategoryById(Integer id) {
        return categoryRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No category with current id found"));
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public boolean deleteById(int id) {
        categoryRepo.deleteById(id);
        return (!categoryRepo.existsById(id));
    }

    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

}
