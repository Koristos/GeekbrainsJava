package ru.geekbrains.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.dto.Cart;
import ru.geekbrains.models.Product;
import ru.geekbrains.util.ProductStack;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class CartService {
    @Autowired
    private Cart cart;

    public boolean putProduct(Product product){
        if(cart.getCart().stream().noneMatch(productStack -> productStack.getProduct().equals(product))){
            cart.getCart().add(new ProductStack(product,1));
        }else {
            ProductStack productStack = cart.getCart().stream()
                    .filter(p -> p.getProduct().equals(product)).findFirst().orElseThrow(()->
            new RuntimeException("SWW with adding product to a cart!"));
            productStack.setNumber(productStack.getNumber()+1);
        }
        cart.setSum(cart.getSum()+product.getPrice());
        return true;
    }

    public boolean removeProductById(int id){
        int price = 0;
        ProductStack productStack = cart.getCart().stream()
                .filter(p -> p.getProduct().getId()==id).findFirst().orElseThrow(()->
                        new RuntimeException("SWW with finding product in a cart!"));
        cart.setSum(cart.getSum()-productStack.getProduct().getPrice());
        if (productStack.getNumber()==1){
            cart.getCart().remove(productStack);
        }else {
            productStack.setNumber(productStack.getNumber() - 1);
        }
        return true;
    }

    public Cart getCart (){
        return cart;
    }

    public boolean saveOrder(){

        return true;
    }
}
