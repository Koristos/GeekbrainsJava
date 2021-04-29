package ru.geekbrains.springlessonfour.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.springlessonfour.dto.Product;
import ru.geekbrains.springlessonfour.repository.CartRepository;

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
