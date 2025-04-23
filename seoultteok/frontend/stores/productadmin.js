import { defineStore } from 'pinia'
import { fetchAllProductsAPI, deleteProductAPI,updateProductAPI, addProductAPI} from '@/api/productadminapi'

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
    },

    async addProduct(productData) {
      await addProductAPI(productData)
    }
  }
})
