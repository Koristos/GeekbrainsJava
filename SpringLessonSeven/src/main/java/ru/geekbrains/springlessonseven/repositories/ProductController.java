package ru.geekbrains.springlessonseven.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springlessonseven.controllers.ProductRepo;
import ru.geekbrains.springlessonseven.models.Product;

import java.util.List;

@RestController
@RequestMapping ("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepo productRepo;

    @GetMapping
    public List<Product> getAllProducts (@RequestParam (required = false) Integer min, @RequestParam (required = false) Integer max){
        System.out.println("11111");
        if (min!=null && max!=null) {
            System.out.println("22222");
            return productRepo.findProductBetween(min, max);
        }else if (min!=null){
            System.out.println("33333");
            return productRepo.findAllByPriceGreaterThanOrderByPrice(min);
        }else if (max!=null){
            System.out.println("4444");
            return productRepo.findAllByPriceLessThanOrderByPrice(max);
        }else return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById (@PathVariable Integer id){
        return productRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Product addProduct (@RequestBody Product product){
        return productRepo.save(product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProductById (@PathVariable Integer id) {
        productRepo.deleteById(id);
        return true;
    }

    @PutMapping
    public boolean updateProduct (@RequestBody Product product){
        if (productRepo.existsById(product.getId())){
            productRepo.save(product);
            return true;
        }
        return false;
    }
}
