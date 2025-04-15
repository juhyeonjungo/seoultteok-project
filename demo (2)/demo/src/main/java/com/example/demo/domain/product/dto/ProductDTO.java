package com.example.demo.domain.product.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDTO {
    private Long productId;
    private String name;
    private String description;
    private Integer stock;
    private String imageUrl;
    private String category;
    private String createdAt;
    private Integer retailPrice;
    private Integer bulkPrice;
}
