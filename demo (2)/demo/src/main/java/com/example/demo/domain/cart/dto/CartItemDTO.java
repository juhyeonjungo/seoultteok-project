package com.example.demo.domain.cart.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private Long cartItemId;
    private Long  cartId;
    private Long  productId;
    private Long  quantity;

    // 아래는 프론트에 보여주기용 (JOIN해서 이름, 이미지, 가격 같이 넘기면 좋음)
    private String name;
    private String image;
    private Long  price;
}