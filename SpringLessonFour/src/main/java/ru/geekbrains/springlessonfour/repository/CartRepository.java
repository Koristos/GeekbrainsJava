package ru.geekbrains.springlessonfour.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.springlessonfour.dto.Product;

import java.util.ArrayList;
import java.util.List;

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
