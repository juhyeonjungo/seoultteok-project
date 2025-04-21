package com.example.demo.domain.order.controller;

import com.example.demo.domain.order.dto.OrderRequest;
import com.example.demo.domain.order.dto.OrderWrapperRequest;
import com.example.demo.domain.order.service.OrderService;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderWrapperRequest wrapper) {
        System.out.println("주문을 했니??????????????????????");
        String email = wrapper.getEmail();
        System.out.println(email);
        OrderRequest request = wrapper.getOrder();
        orderService.createOrder(email, request);
        return ResponseEntity.ok("주문 완료");
    }
}