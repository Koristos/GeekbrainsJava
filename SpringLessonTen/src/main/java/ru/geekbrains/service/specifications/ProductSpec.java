package ru.geekbrains.service.specifications;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.models.Product;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpec {

    public static Specification<Product> categoryBound(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), id);
    }
}
