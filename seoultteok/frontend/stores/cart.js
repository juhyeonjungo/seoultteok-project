import { defineStore } from 'pinia'
import { createCart, addItemToCart, fetchCartItems, updateCartItem, removeCartItem , removeAllCartItems } from '@/api/cartapi'

export const useCartStore = defineStore('cart', {
  state: () => ({
    cartId: null,
    items: [], // { cartItemId, productId, name, price, quantity, image }
  }),

  getters: {
    totalPrice: (state) => state.items.reduce((sum, item) => sum + item.price * item.quantity, 0),
    totalCount: (state) => state.items.reduce((sum, item) => sum + item.quantity, 0),
  },

  actions: {
    // 장바구니 생성
    async initCart(memberId) {
      console.log(33333333);
      const res = await createCart(memberId)
      console.log("카트 아이디는?:"+ res.data.cartId);
      this.cartId = res.data.cartId
      this.items=[]
    },
    // 장바구니 조회
    async fetchCart(email) {
      const res = await fetchCartItems(email)
      console.log("백엔드 응답", res.data);
      this.cartId = res.data.cartId
      this.items = res.data.items
      console.log("정주현"+this.cartId);
    },
   // 장바구니 담기
    async addToCart(product) {
      console.log("왜 쳐 안나와 아이디가"+this.cartId)
      const existing = this.items.find(item => item.productId === product.productId)
      if (existing) {
        existing.quantity += 1
        await updateCartItem(existing.cartItemId, existing.quantity)
      } else {
        const res = await addItemToCart(this.cartId, product.productId, 1)
        this.items.push({
          cartItemId: res.data.cartItemId,
          productId: product.productId,
          name: product.name,
          price: product.retailPrice,
          quantity: 1,
          image: product.imageUrl
        })
      }
    },
    
    async updateQuantity(cartItemId, quantity) {
      await updateCartItem(cartItemId, quantity)
      const item = this.items.find(item => item.cartItemId === cartItemId)
      if (item) item.quantity = quantity
    },
    // 상품 선택 후 삭제 뒤  그 장바구니 조회
    async removeFromCart(cartItemId) {
      await removeCartItem(cartItemId)
      this.items = this.items.filter(item => item.cartItemId !== cartItemId)
    },
   // 결제 완료 뒤 장바구니 삭제 
    async clearCart() {
      if (!this.cartId) return
      await removeAllCartItems(this.cartId) // axios 요청
      this.items = []
    }
  }
})
