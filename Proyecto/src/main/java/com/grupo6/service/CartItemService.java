/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.service;

import com.grupo6.domain.CartItem;
import java.util.List;

/**
 *
 * @author Morgan
 */
public interface CartItemService {
    void saveCartItem(CartItem cartItem);
    List<CartItem> getAllCartItems();
    void deleteCartItem(Long id);
    double calculateTotal();
    void emptyCart();
}
