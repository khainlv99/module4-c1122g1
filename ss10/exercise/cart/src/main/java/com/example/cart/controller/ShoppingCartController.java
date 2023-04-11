package com.example.cart.controller;

import com.example.cart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    @ModelAttribute("cart")
    public Cart setupCart () {
        return new Cart();
    }

    @GetMapping("")
    public String showCart (@SessionAttribute ("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "/cart";
    }
}
