package com.example.demo.domain.admin.mapper;

import com.example.demo.domain.admin.dto.AdminOrderResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminOrderMapper {
    List<AdminOrderResponse> findAllOrdersWithItems();
    void updateOrderStatus(@Param("orderId") Long orderId, @Param("status") String status);
}
