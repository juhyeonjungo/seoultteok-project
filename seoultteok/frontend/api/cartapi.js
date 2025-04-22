// api/cartapi.js
import { useNuxtApp } from '#app'

export async function createCart(memberId) {
  const { $axios } = useNuxtApp()
  
  return await $axios.post(`/cart/${memberId}`)
}

export async function addItemToCart(cartId, productId, quantity) {
  const { $axios } = useNuxtApp()
  return await $axios.post(`/cart/${cartId}/items`, {
    productId,
    quantity
  })
}

export async function fetchCartItems(email) {
    const { $axios } = useNuxtApp()
    return await $axios.get(`/cart`, {
      params: { email }
    })
}

export async function updateCartItem(cartItemId, quantity) {
  const { $axios } = useNuxtApp()
  return await $axios.put(`/cart/items/${cartItemId}`, { quantity })
}

export async function removeCartItem(cartItemId) {
  const { $axios } = useNuxtApp()
  return await $axios.delete(`/cart/items/${cartItemId}`)
}


export async function removeAllCartItems(cartId) {
  const { $axios } = useNuxtApp()
  return await $axios.delete(`/cart/${cartId}/items`)
}