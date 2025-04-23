package com.example.demo.domain.admin.controller;


import com.example.demo.domain.admin.dto.AdminSalesResponse;
import com.example.demo.domain.admin.service.AdminSalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/sales")
@RequiredArgsConstructor
public class AdminSalesController {

    private final AdminSalesService adminsalesService;


    @GetMapping
    public ResponseEntity<AdminSalesResponse> getSales(@RequestParam String period) {
        AdminSalesResponse response = adminsalesService.getSalesData(period);
        System.out.println("💬 반환 객체: " + response); // 이거 로그 꼭 찍기
        return ResponseEntity.ok(response);
    }
}
