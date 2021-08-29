package ru.geekbrains.summer.market.services;

import com.geekbrains.ru.summer.market.productview.ProductView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Page<Product> findPage(int pageIndex, int pageSize, Specification<Product> spec) {
        return productRepository.findAll(spec, PageRequest.of(pageIndex, pageSize));
    }

    public Product save(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public ProductView getProductViewById (Long id){
        Product product = findById(id).orElse(null);
        if (product==null) return null;
        return productToView(product) ;
    }

    public List<ProductView> getAllProductViews() {
        List<ProductView> viewList = new ArrayList<>();
        findAll().forEach(p -> viewList.add(productToView(p)));
        return viewList;
    }

    private ProductView productToView (Product product){
        ProductView view = new ProductView();
        view.setId(product.getId());
        view.setPrice(product.getPrice());
        view.setTitle(product.getTitle());
        view.setCategoryTitle(product.getCategory().getTitle());
        return view;
    }
}
