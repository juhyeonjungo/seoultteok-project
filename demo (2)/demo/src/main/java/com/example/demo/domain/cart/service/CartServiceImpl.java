package com.example.demo.domain.cart.service;

import com.example.demo.domain.cart.dto.CartDTO;
import com.example.demo.domain.cart.dto.CartItemDTO;
import com.example.demo.domain.cart.dto.CartResponse;
import com.example.demo.domain.cart.mapper.CartMapper;
import com.example.demo.domain.member.dto.Member;
import com.example.demo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;
    private final MemberService memberService; // ✅ MemberService 사용

    @Override
    public CartDTO createCart(String email) {
        cartMapper.insertCartByEmail(email); // 이메일만으로 장바구니 생성 (XML에서 JOIN)
        Long cartId = cartMapper.findCartIdByEmail(email); // 이메일로 cartId 조회
        return new CartDTO(cartId, null); // memberId는 굳이 안 넘겨도 됨
    }

    // ✅ 2. 장바구니 조회 (이메일 기반 → cartId + cartItems)
    @Override
    public CartResponse fetchCartByEmail(String email) {
        List<CartItemDTO> items = cartMapper.findCartItemsByEmail(email);
        Long cartId;

        if (items.isEmpty()) {
            cartId = cartMapper.findCartIdOnlyByEmail(email); // 아이템이 없더라도 cartId만 조회
            System.out.println("조인이안됐습니다");         // 상품 선택 안했을 경우  cart 테이블에 있는 cartId 컬럼만 추출
        } else {
            cartId = items.get(0).getCartId();
            System.out.println("조인이됐습니다");          // 상품 선택 했을 경우    cart 테이블과 cart_item 테이블 조인 후 cartId 컬럼 추출
        }

        return new CartResponse(cartId, items);
    }   // 처음 회원가입을 하고 로그인을 했어 장바구니를 처음 쓰는 상태야 그러면 findCartItemByEmail ==null

    @Override
    public CartItemDTO addItemToCart(Long cartId, CartItemDTO item) {
        item.setCartId(cartId);  // cartId 세팅
        cartMapper.insertCartItem(item);  // insert 실행
        Long newCartItemId = cartMapper.findLastInsertedCartItemId();  // 시퀀스 currval로 가져오기
        item.setCartItemId(newCartItemId); // 새로 생성된 id 설정
        return item;
    }
    @Override
    public void updateCartItem(Long cartItemId, int quantity) {
        cartMapper.updateCartItemQuantity(cartItemId, quantity);
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        cartMapper.deleteCartItem(cartItemId);
    }
}
