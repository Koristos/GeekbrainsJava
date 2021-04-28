package ru.geekbrains.SpringLessonThree.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringLessonThree.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class CartRepository {
    private static final List<Product> cartList=new ArrayList<>();

    public void addProduct (Product product){
        cartList.add(product);
    }

    public void removeProduct (Product product) {
        cartList.remove(product);
    }

    public List<Product> getAllProducts(){
        return cartList;
    }

    public void clearCart(){
        cartList.clear();
    }
}
