package com.example.demo.domain.admin.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdminOrderResponse {
    private Long orderId;
    private String email;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String status;
    private List<AdminOrderItemDTO> orderItems;
}
