package com.example.demo.domain.admin.controller;


import com.example.demo.domain.admin.dto.AdminProductDTO;
import com.example.demo.domain.admin.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
@RequiredArgsConstructor
public class AdminProductController {
    private final AdminProductService adminProductService;

    @GetMapping
    public List<AdminProductDTO> getAllProducts() {
        return adminProductService.getAllProducts();
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        adminProductService.deleteProduct(productId);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long productId, @RequestBody AdminProductDTO dto) {
        adminProductService.updateProduct(productId, dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addProduct(@RequestBody AdminProductDTO dto) {
        adminProductService.addProduct(dto);
        return ResponseEntity.ok().build();
    }
}
