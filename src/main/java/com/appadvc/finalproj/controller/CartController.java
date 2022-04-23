package com.appadvc.finalproj.controller;

import com.appadvc.finalproj.dto.CartDTO;
import com.appadvc.finalproj.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("carts", cartService.list());
        return "cart/index";
    }

    @GetMapping("/add")
    private String getCartAddForm(Model model) {
        model.addAttribute("cart", new CartDTO());
        return "cart/add-cart";
    }

    @PostMapping
    private String add(@Valid @ModelAttribute("cart") CartDTO cart, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cart", cart);
            return "cart/add-cart";
        }
        cartService.add(cart);
        return list(model);
    }

    @GetMapping("/{cartID}")
    private String get(@PathVariable Long cartID, Model model) {
        model.addAttribute("cart", cartService.get(cartID));
        return "cart/view-cart";
    }

    @PutMapping
    private String update(CartDTO cartDTO, Model model) {
        cartService.update(cartDTO);
        return list(model);
    }

    @DeleteMapping
    private String delete(CartDTO cartDTO, Model model) {
        cartService.delete(cartDTO.getCartID());
        return list(model);
    }
}
