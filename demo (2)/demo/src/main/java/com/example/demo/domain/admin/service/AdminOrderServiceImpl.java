package com.example.demo.domain.admin.service;

import com.example.demo.domain.admin.dto.AdminOrderResponse;
import com.example.demo.domain.admin.mapper.AdminOrderMapper;
import com.example.demo.domain.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminOrderServiceImpl implements AdminOrderService{

    private final AdminOrderMapper adminOrderMapper;

    @Override
    public List<AdminOrderResponse> getAllOrders() {
        return adminOrderMapper.findAllOrdersWithItems();
    }

    @Override
    public void updateOrderStatus(Long orderId, String status) {
        adminOrderMapper.updateOrderStatus(orderId, status);
    }
}
