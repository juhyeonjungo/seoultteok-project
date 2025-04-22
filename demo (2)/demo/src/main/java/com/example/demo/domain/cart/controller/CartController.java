package com.example.demo.domain.cart.controller;


import com.example.demo.domain.cart.dto.CartDTO;
import com.example.demo.domain.cart.dto.CartItemDTO;
import com.example.demo.domain.cart.dto.CartResponse;
import com.example.demo.domain.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    // ✅ 1. 장바구니 생성 (POST /api/cart/{memberId})
    @PostMapping("/{email}")
    public ResponseEntity<CartDTO> createCart(@PathVariable String email) {
        CartDTO cart = cartService.createCart(email); // email로 서비스 호출
        return ResponseEntity.ok(cart);
    }

    // ✅ 2. 장바구니 조회 (GET /api/cart/{email})
    @GetMapping
    public ResponseEntity<CartResponse> fetchCart(@RequestParam String email) {
        CartResponse response = cartService.fetchCartByEmail(email);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemDTO> addItemToCart(@PathVariable Long cartId, @RequestBody CartItemDTO request) {
        CartItemDTO inserted = cartService.addItemToCart(cartId, request);
        return ResponseEntity.ok(inserted);
    }

    @PutMapping("/items/{cartItemId}")
    public ResponseEntity<Void> updateCartItem(@PathVariable Long cartItemId, @RequestBody Map<String, Integer> body) {
        int quantity = body.get("quantity");
        cartService.updateCartItem(cartItemId, quantity);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/items/{cartItemId}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long cartItemId) {
        cartService.removeCartItem(cartItemId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cartId}/items")
    public ResponseEntity<Void> clearCart(@PathVariable Long cartId) {
        cartService.clearCart(cartId);
        return ResponseEntity.ok().build();
    }


}