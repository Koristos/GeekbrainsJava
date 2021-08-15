package ru.geekbrains.springlessonfour.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.springlessonfour.dto.Cart;
import ru.geekbrains.springlessonfour.dto.Product;
import ru.geekbrains.springlessonfour.dao.CartDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartDao cartDao;

    public void submitPurchase(Cart cart){
        cartDao.submitPurchase(cart);
    }

}
