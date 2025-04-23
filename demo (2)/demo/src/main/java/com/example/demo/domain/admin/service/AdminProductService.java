package com.example.demo.domain.admin.service;

import com.example.demo.domain.admin.dto.AdminProductDTO;

import java.util.List;

public interface AdminProductService {
    List<AdminProductDTO> getAllProducts();
    void deleteProduct(Long productId);
    void updateProduct(Long productId, AdminProductDTO dto);
    void addProduct(AdminProductDTO dto);


}
