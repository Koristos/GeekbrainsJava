package ru.geekbrains.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.geekbrains.util.ProductStack;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Cart {
    private List<ProductStack> cart;
    private int sum;

    Cart(){
        this.cart = new ArrayList<>();
        this.sum = 0;
    }

}
