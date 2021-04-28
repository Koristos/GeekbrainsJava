package ru.geekbrains.SpringLessonThree.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.SpringLessonThree.dto.Cart;
import ru.geekbrains.SpringLessonThree.dto.Product;
import ru.geekbrains.SpringLessonThree.service.CartService;
import ru.geekbrains.SpringLessonThree.service.ProductService;

import java.util.UUID;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping
    @ModelAttribute("cart")
    public Cart showHtml() {
        Cart cart = new Cart();
        cart.setCartContent(cartService.getAllProducts());
        cart.setCount(cart.getCartContent().size());
        cart.setTotal(cart.getCartContent().stream().mapToDouble(Product::getPrice).sum());
        return cart;
    }



    @GetMapping(value="/add")
    public ModelAndView addToCart(@RequestParam UUID id){
        cartService.addProduct(productService.getProductById(id));
        ModelAndView model = new ModelAndView("redirect:" + "../info");
        model.addObject("message", "Product successfully added to your cart!");
        return model;
    }

    @GetMapping(value="/delete")
    public ModelAndView deleteFromCart(@RequestParam UUID id){
        cartService.removeProduct(productService.getProductById(id));
        ModelAndView model = new ModelAndView("redirect:" + "../info");
        model.addObject("message", "Product successfully deleted from your cart!");
        return model;
    }

    @GetMapping(value="/submit")
    public ModelAndView submitCart(){
        cartService.submitPurchase();
        ModelAndView model = new ModelAndView("redirect:" + "../info");
        model.addObject("message", "You made a purchase! Congratulations!");
        return model;
    }
}
