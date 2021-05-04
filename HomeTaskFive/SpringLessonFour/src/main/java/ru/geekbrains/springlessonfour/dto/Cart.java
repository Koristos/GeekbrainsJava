package ru.geekbrains.springlessonfour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@SessionScope
public class Cart {

    private String total;
    private Integer count;
    private ArrayList<Product> cartContent;
    private UUID cartId;

    @PostConstruct
    public void init(){
        this.cartContent = new ArrayList<>();
        this.cartId = UUID.randomUUID();
    }

    public void addProduct(Product product){
        cartContent.add(product);
    }

    public void removeProduct(Product product){
        cartContent.remove(product);
    }

    public void count(){
        Double value =cartContent.stream().mapToDouble(Product::getPrice).sum();
        this.total=(String.format("%.2f",value));
        this.count=cartContent.size();
    }
}
