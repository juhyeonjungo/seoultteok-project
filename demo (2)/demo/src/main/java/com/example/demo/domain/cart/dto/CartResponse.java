package com.example.demo.domain.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartResponse {
    private Long cartId;
    private List<CartItemDTO> items;
}