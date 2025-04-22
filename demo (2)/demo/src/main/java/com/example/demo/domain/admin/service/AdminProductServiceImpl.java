package com.example.demo.domain.admin.service;

import com.example.demo.domain.admin.dto.AdminProductDTO;
import com.example.demo.domain.admin.mapper.AdminProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {

    private final AdminProductMapper adminProductMapper;

    @Override
    public List<AdminProductDTO> getAllProducts() {
        return adminProductMapper.findAllProducts();
    }

    @Override
    public void deleteProduct(Long productId) {
        adminProductMapper.deleteProduct(productId);
    }

    @Override
    public void updateProduct(Long productId, AdminProductDTO dto) {
        dto.setProductId(productId); // 혹시 모르니 ID 세팅
        adminProductMapper.updateProduct(dto);
    }
}
