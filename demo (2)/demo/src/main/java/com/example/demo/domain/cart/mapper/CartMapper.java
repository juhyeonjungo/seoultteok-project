package com.example.demo.domain.cart.mapper;

import com.example.demo.domain.cart.dto.CartItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    // ✅ 이메일로 바로 CART INSERT (JOIN 처리: email → memberId → INSERT)
    void insertCartByEmail(@Param("email") String email);

    // ✅ 이메일로 CART_ID 조회
    Long findCartIdByEmail(@Param("email") String email);

    // ✅ 상품 추가
    void insertCartItem(CartItemDTO item);

    // ✅ 장바구니 전체 조회 (상품 정보 포함)
    List<CartItemDTO> findCartItemsByEmail(@Param("email") String email);

    Long findCartIdOnlyByEmail(@Param("email") String email);

    Long findLastInsertedCartItemId();

    void updateCartItemQuantity(@Param("cartItemId") Long cartItemId, @Param("quantity") int quantity);

    void deleteCartItem(Long cartItemId);
}
