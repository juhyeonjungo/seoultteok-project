package com.example.demo.domain.order.dto;

import lombok.Data;

@Data
public class OrderItemInfoDTO {
    private Long productId;
    private String name;
    private String imageUrl;
    private int price;
    private int quantity;
}
