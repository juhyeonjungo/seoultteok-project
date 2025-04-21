package com.example.demo.domain.order.dto;

import lombok.Data;

@Data
public class OrderWrapperRequest {
    private String email;
    private OrderRequest order;
}