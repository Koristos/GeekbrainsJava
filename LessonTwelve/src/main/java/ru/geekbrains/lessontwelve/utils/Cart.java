package ru.geekbrains.lessontwelve.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.lessontwelve.models.OrderItem;
import ru.geekbrains.lessontwelve.models.Product;
import ru.geekbrains.lessontwelve.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class Cart {
    private final List<OrderItem> content;
    private int totalPrice;
    @Autowired
    private ProductService productService;

    Cart () {
        this.content = new ArrayList<>();
        this.totalPrice=0;
    }

    public boolean addProduct (int productId){
        OrderItem item = findOrderItemByProductId(productId);
        if (item==null){
            item = new OrderItem();
            Product product = productService.findProductById(productId);
            item.setProduct(product);
            item.setPrice(product.getPrice());
            item.setItemNumber(1);
            content.add(item);
        }else {
            item.setItemNumber(item.getItemNumber()+1);
        }
        calculateTotalPrice();
        return true;
    }

    public boolean removeProduct(int productId){
        OrderItem item = findOrderItemByProductId(productId);
        if (item==null||item.getItemNumber()<1){
            System.out.println("Invalid cart content!");
            return false;
        }else if (item.getItemNumber()==1){
            content.remove(item);
        }else {
            item.setItemNumber(item.getItemNumber()-1);
        }
        calculateTotalPrice();
        return true;
    }



    private void calculateTotalPrice(){
        this.totalPrice = content.stream()
                .mapToInt(o-> o.getPrice()*o.getItemNumber())
                .sum();
    }

    private OrderItem findOrderItemByProductId (int productId){
        Product product = productService.findProductById(productId);
        return content.stream()
                .filter(i->i.getProduct().equals(product))
                .findFirst()
                .orElse(null);
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
