package com.example.demo.domain.order.service;

import com.example.demo.domain.order.dto.OrderRequest;
import com.example.demo.domain.order.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    void createOrder(String email, OrderRequest request);
    List<OrderResponse> getOrdersByEmail(String email);
}