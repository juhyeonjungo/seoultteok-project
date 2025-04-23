package com.example.demo.domain.admin.service;


import com.example.demo.domain.admin.dto.AdminSalesResponse;
import com.example.demo.domain.admin.mapper.AdminSalesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminSalesServiceImpl implements AdminSalesService {

    private final AdminSalesMapper adminsalesMapper;

    @Override
    public AdminSalesResponse getSalesData(String period) {
        AdminSalesResponse response = new AdminSalesResponse();

        // 총 매출
        response.setTotalRevenue(adminsalesMapper.getTotalRevenue(period));

        // 일/월/연도별
        response.setPeriodLabels(adminsalesMapper.getPeriodLabels(period));
        response.setPeriodValues(adminsalesMapper.getPeriodValues(period));

        // 상품별
        response.setProductLabels(adminsalesMapper.getTopProductNames());
        response.setProductValues(adminsalesMapper.getTopProductSales());

        // 카테고리별
        response.setCategoryLabels(adminsalesMapper.getCategoryNames());
        response.setCategoryValues(adminsalesMapper.getCategorySales());

        return response;
    }
}
