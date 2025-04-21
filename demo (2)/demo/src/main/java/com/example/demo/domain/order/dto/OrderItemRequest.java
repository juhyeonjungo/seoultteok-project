package com.example.demo.domain.order.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long productId;
    private int quantity;
    private int price;
}
