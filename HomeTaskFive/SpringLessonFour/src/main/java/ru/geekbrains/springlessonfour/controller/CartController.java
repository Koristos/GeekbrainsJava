
package ru.geekbrains.springlessonfour.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.springlessonfour.dto.Cart;
import ru.geekbrains.springlessonfour.dto.Product;
import ru.geekbrains.springlessonfour.service.CartService;
import ru.geekbrains.springlessonfour.service.ProductService;


@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private Cart cart;
    private final CartService cartService;
    private final ProductService productService;

    @GetMapping
    @ModelAttribute("cart")
    public Cart showHtml() {
        cart.count();
        return cart;
    }



    @GetMapping(value="/add")
    public ModelAndView addToCart(@RequestParam Integer id){
        cart.addProduct(productService.getProductById(id));
        ModelAndView model = new ModelAndView("redirect:" + "../info");
        model.addObject("message", "Product successfully added to your cart!");
        return model;
    }

    @GetMapping(value="/delete")
    public ModelAndView deleteFromCart(@RequestParam Integer id){
        cart.removeProduct(productService.getProductById(id));
        ModelAndView model = new ModelAndView("redirect:" + "../info");
        model.addObject("message", "Product successfully deleted from your cart!");
        return model;
    }

    @GetMapping(value="/submit")
    public ModelAndView submitCart(){
        cartService.submitPurchase(cart);
        cart=new Cart();
        cart.init();
        ModelAndView model = new ModelAndView("redirect:" + "../info");
        model.addObject("message", "You made a purchase! Congratulations!");
        return model;
    }
}


