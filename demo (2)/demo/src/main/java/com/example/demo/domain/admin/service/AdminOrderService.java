package com.example.demo.domain.admin.service;

import com.example.demo.domain.admin.dto.AdminOrderResponse;

import java.util.List;

public interface AdminOrderService {

    List<AdminOrderResponse> getAllOrders();
    void updateOrderStatus(Long orderId, String status);
}
