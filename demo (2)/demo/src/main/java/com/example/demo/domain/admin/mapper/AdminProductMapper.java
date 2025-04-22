package com.example.demo.domain.admin.mapper;


import com.example.demo.domain.admin.dto.AdminProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminProductMapper {
    List<AdminProductDTO> findAllProducts();
    void deleteProduct(Long productId);
    void updateProduct(AdminProductDTO dto);
}
