package com.example.demo.domain.order.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;
    private String memo;
    private int totalPrice;
    private List<OrderItemRequest> items;
}