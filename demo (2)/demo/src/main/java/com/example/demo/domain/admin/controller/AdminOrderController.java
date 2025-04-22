package com.example.demo.domain.admin.controller;


import com.example.demo.domain.admin.dto.AdminOrderResponse;
import com.example.demo.domain.admin.service.AdminOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/orders")
@RequiredArgsConstructor
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    @GetMapping
    public List<AdminOrderResponse> getAllOrders() {
        return adminOrderService.getAllOrders();
    }

    @PutMapping("/{orderId}/status")
    public void updateOrderStatus(@PathVariable Long orderId, @RequestBody Map<String, String> body) {
        String status = body.get("status");
        adminOrderService.updateOrderStatus(orderId, status);
    }
}
