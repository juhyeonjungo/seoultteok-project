package com.example.demo.domain.order.service;

import com.example.demo.domain.order.dto.OrderRequest;

public interface OrderService {
    void createOrder(String email, OrderRequest request);
}