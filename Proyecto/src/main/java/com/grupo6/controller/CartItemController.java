/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.controller;

import com.grupo6.domain.CartItem;
import com.grupo6.domain.Implemento;
import com.grupo6.domain.Suplemento;
import com.grupo6.domain.Vestimenta;
import com.grupo6.service.CartItemService;
import com.grupo6.service.ImplementoService;
import com.grupo6.service.SuplementoService;
import com.grupo6.service.VestimentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Morgan
 */
@Controller
public class CartItemController {

    @Autowired
    private ImplementoService implementoService;

    @Autowired
    private SuplementoService suplementoService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private VestimentaService vestimentaService;

    @PostMapping("/implementos/{id}/cartItems")
    public String addImplementoToCart(@PathVariable Long id, @ModelAttribute CartItem cartItem) {
        Implemento implemento = implementoService.getImplementoById(id);

        cartItem.setImplemento(implemento);

        cartItemService.saveCartItem(cartItem);

        return "redirect:/implementos/" + id;
    }

    @PostMapping("/suplementos/{id}/cartItems")
    public String addSuplementoToCart(@PathVariable Long id, @ModelAttribute CartItem cartItem) {
        Suplemento suplemento = suplementoService.getSuplementoById(id);

        cartItem.setSuplemento(suplemento);

        cartItemService.saveCartItem(cartItem);

        return "redirect:/suplementos/" + id;
    }

    @PostMapping("/vestimentas/{id}/cartItems")
    public String addVestimentaToCart(@PathVariable Long id, @ModelAttribute CartItem cartItem) {
        Vestimenta vestimenta = vestimentaService.getVestimentaById(id);

        cartItem.setVestimenta(vestimenta);

        cartItemService.saveCartItem(cartItem);

        return "redirect:/vestimentas/" + id;
    }
}
