package com.example.demo.domain.order.mapper;

import com.example.demo.domain.order.dto.OrderResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    void insertOrder(
            @Param("memberId") Long memberId,
            @Param("receiverName") String receiverName,
            @Param("receiverAddress") String receiverAddress,
            @Param("receiverPhone") String receiverPhone,
            @Param("memo") String memo,
            @Param("totalPrice") int totalPrice
    );

    Long getLastOrderId();

    void insertOrderItem(
            @Param("orderId") Long orderId,
            @Param("productId") Long productId,
            @Param("quantity") int quantity,
            @Param("price") int price
    );

    List<OrderResponse> findOrdersByEmail(String email);
}