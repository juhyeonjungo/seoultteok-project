package com.example.demo.domain.admin.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdminSalesResponse {
    private Integer totalRevenue;

    private List<String> periodLabels;
    private List<Integer> periodValues;

    private List<String> productLabels;
    private List<Integer> productValues;

    private List<String> categoryLabels;
    private List<Integer> categoryValues;
}
