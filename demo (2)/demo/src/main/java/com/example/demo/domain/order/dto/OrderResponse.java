package com.example.demo.domain.order.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long orderId;
    private String orderDate;
    private int totalPrice;
    private String status;

    private List<OrderItemInfoDTO> items;  // 🧾 주문 내역에 포함된 상품 리스트
}