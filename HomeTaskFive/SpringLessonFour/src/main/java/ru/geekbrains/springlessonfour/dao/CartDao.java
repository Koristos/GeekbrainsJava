package ru.geekbrains.springlessonfour.dao;

import org.springframework.stereotype.Repository;
import ru.geekbrains.springlessonfour.dto.Cart;
import ru.geekbrains.springlessonfour.dto.Order;
import ru.geekbrains.springlessonfour.dto.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CartDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void submitPurchase(Cart cart){
        for (Product p: cart.getCartContent()) {
            Order order = new Order();
            order.setCartId(cart.getCartId().toString());
            order.setProdictId(p.getId());
            entityManager.persist(order);
        }
    }
}
