package com.example.demo.domain.cart.service;

import com.example.demo.domain.cart.dto.CartDTO;
import com.example.demo.domain.cart.dto.CartItemDTO;
import com.example.demo.domain.cart.dto.CartResponse;

public interface CartService {

    CartDTO createCart(String email);
    CartResponse fetchCartByEmail(String email);
    CartItemDTO addItemToCart(Long cartId, CartItemDTO item);
    void updateCartItem(Long cartItemId, int quantity);
    void removeCartItem(Long cartItemId);
}
