import { defineStore } from 'pinia'
import { fetchAllProductsAPI, deleteProductAPI,updateProductAPI} from '@/api/productadminapi'

export const useProductAdminStore = defineStore('productadmin', {
  state: () => ({
    products: []
  }),
  actions: {
    async fetchAllProducts() {
      const res = await fetchAllProductsAPI()
      this.products = res
      return res
    },
    async updateProduct(productData) {
        await updateProductAPI(productData)
      },

    async deleteProduct(productId) {
      await deleteProductAPI(productId)
    }
  }
})
