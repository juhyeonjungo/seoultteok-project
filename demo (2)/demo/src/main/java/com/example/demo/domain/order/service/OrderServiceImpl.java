package com.example.demo.domain.order.service;

import com.example.demo.domain.member.dto.Member;
import com.example.demo.domain.member.mapper.MemberMapper;
import com.example.demo.domain.order.dto.OrderItemRequest;
import com.example.demo.domain.order.dto.OrderRequest;
import com.example.demo.domain.order.dto.OrderResponse;
import com.example.demo.domain.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final MemberMapper memberMapper;

    @Override
    public void createOrder(String email, OrderRequest request) {
        System.out.println("이메일: " + email);
        Member member = memberMapper.findByEmail(email);
        System.out.println("조회된 member: " + member);
        System.out.println("에러확인용:"+member.getMemberId());
        // 1. 주문 저장
        orderMapper.insertOrder(member.getMemberId(), request.getReceiverName(), request.getReceiverAddress(), request.getReceiverPhone(), request.getMemo(), request.getTotalPrice());
        Long orderId = orderMapper.getLastOrderId();

        // 2. 주문 상세 저장
        for (OrderItemRequest item : request.getItems()) {
            orderMapper.insertOrderItem(
                    orderId,
                    item.getProductId(),
                    item.getQuantity(),
                    item.getPrice()
            );
        }
    }

    @Override
    public List<OrderResponse> getOrdersByEmail(String email) {
        return orderMapper.findOrdersByEmail(email);
    }
}