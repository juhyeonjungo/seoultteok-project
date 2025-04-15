// stores/products.js
import { defineStore } from 'pinia'
import { fetchProducts } from '@/api/productapi'

export const useProductStore = defineStore('product', {
  state: () => ({
    products: []
  }),

  actions: {
    async loadProducts() {
      try {
        const response = await fetchProducts()
        this.products = response.data
        console.log(this.products);
      } catch (error) {
        console.error('상품 목록 불러오기 실패:', error)
      }
    }
  }
})
