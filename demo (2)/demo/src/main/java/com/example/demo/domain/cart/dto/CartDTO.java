package com.example.demo.domain.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDTO {
        private Long  cartId;
        private Long  memberId;

}
