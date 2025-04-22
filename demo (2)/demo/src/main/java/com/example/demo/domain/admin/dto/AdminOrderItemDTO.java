package com.example.demo.domain.admin.dto;

import lombok.Data;

@Data
public class AdminOrderItemDTO {

    private Long productId;
    private String name;
    private int quantity;
}
