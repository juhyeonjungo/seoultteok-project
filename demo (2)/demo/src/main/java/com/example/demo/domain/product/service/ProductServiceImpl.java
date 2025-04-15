package com.example.demo.domain.product.service;

import com.example.demo.domain.product.dto.ProductDTO;
import com.example.demo.domain.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productMapper.findAll();
    }

}
