package com.example.demo.domain.admin.service;

import com.example.demo.domain.admin.dto.AdminSalesResponse;

public interface AdminSalesService {
    AdminSalesResponse getSalesData(String period);
}
