/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.service.impl;

import com.grupo6.dao.CartItemDao;
import com.grupo6.domain.CartItem;
import com.grupo6.service.CartItemService;
import com.grupo6.service.ImplementoService;
import com.grupo6.service.SuplementoService;
import com.grupo6.service.VestimentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Morgan
 */
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Autowired
    private ImplementoService implementoService;

    @Autowired
    private SuplementoService suplementoService;

    @Autowired
    private VestimentaService vestimentaService;

    @Override
    public void saveCartItem(CartItem cartItem) {
        cartItemDao.save(cartItem);
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemDao.findAll();
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemDao.deleteById(id);
    }

    @Override
    public double calculateTotal() {
        List<CartItem> cartItems = getAllCartItems();
        double total = 0;
        for (CartItem item : cartItems) {
            if (item.getImplemento() != null) {
                total += implementoService.getImplementoById(item.getImplemento().getId()).getPrecio();
            }
            if (item.getSuplemento() != null) {
                total += suplementoService.getSuplementoById(item.getSuplemento().getId()).getPrecio();
            }
            if (item.getVestimenta() != null) {
                total += vestimentaService.getVestimentaById(item.getVestimenta().getId()).getPrecio();
            }
        }
        return total;
    }

    @Override
    public void emptyCart() {
        cartItemDao.deleteAll();
    }
}
