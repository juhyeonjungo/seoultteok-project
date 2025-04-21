// frontend/api/orderapi.js
import { useNuxtApp } from '#app'

export async function createOrder(email, orderData) {
    const { $axios } = useNuxtApp()
    return await $axios.post('/orders/create', {
      email,
      order: orderData
    })
  }
  export async function fetchOrders(email) {
    const { $axios } = useNuxtApp()
    return await $axios.get('/orders', {
      params: { email }
    })
  }