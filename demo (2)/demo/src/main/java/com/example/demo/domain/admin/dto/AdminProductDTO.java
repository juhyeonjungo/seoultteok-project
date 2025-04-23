package com.example.demo.domain.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminProductDTO {
    private Long productId;
    private String name;
    private String description;
    private String category;
    private int stock;
    private String imageUrl;
    private Integer retailPrice;
    private Integer bulkPrice;
}
