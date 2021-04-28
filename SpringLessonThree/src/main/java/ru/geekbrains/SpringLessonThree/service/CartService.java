package ru.geekbrains.SpringLessonThree.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.SpringLessonThree.dto.Product;
import ru.geekbrains.SpringLessonThree.repository.CartRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cart;

    public void addProduct (Product product){
        cart.addProduct(product);
    }

    public void removeProduct (Product product) {
        cart.removeProduct(product);
    }

    public List<Product> getAllProducts(){
        return cart.getAllProducts();
    }

    public void submitPurchase(){
        cart.clearCart();
    }

}
