package com.example.demo.domain.product.mapper;

import com.example.demo.domain.product.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDTO> findAll();
}