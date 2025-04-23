import { useNuxtApp } from '#app'

export async function fetchAllProductsAPI() {
  const { $axios } = useNuxtApp()
  const res = await $axios.get('/admin/products')
  return res.data
}

export async function deleteProductAPI(productId) {
  const { $axios } = useNuxtApp()
  await $axios.delete(`/admin/products/${productId}`)
}

export async function updateProductAPI(productData) {
    const { $axios } = useNuxtApp()
    await $axios.put(`/admin/products/${productData.productId}`, productData)
  }

export async function addProductAPI(productData) {
    const { $axios } = useNuxtApp()
    await $axios.post('/admin/products/add', productData)
  }