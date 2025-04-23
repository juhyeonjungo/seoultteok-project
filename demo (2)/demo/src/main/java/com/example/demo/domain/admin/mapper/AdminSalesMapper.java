package com.example.demo.domain.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminSalesMapper {
    Integer getTotalRevenue(@Param("period") String period);
    List<String> getPeriodLabels(@Param("period") String period);
    List<Integer> getPeriodValues(@Param("period") String period);

    List<String> getTopProductNames();
    List<Integer> getTopProductSales();

    List<String> getCategoryNames();
    List<Integer> getCategorySales();
}
