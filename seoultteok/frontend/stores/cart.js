// stores/cart.js
import { defineStore } from 'pinia'

export const useCartStore = defineStore('cart', {
  state: () => ({
    items: [], // { productId, name, price, quantity, image }
  }),

  getters: {
    totalPrice: (state) => {
      return state.items.reduce((total, item) => total + item.price * item.quantity, 0)
    },
    totalCount: (state) => {
      return state.items.reduce((count, item) => count + item.quantity, 0)
    },
  },

  actions: {
    addToCart(product) {
      const existing = this.items.find(item => item.productId === product.productId)
      if (existing) {
        existing.quantity++
      } else {
        this.items.push({
          productId: product.productId,
          name: product.name,
          price: product.retailPrice,
          quantity: 1,
          image: product.imageUrl,
        })
      }
    },
    removeFromCart(productId) {
      this.items = this.items.filter(item => item.productId !== productId)
    },
    updateQuantity(productId, quantity) {
      const item = this.items.find(item => item.productId === productId)
      if (item) item.quantity = quantity
    },
    clearCart() {
      this.items = []
    },
  }
})
