// frontend/api/orderapi.js
import { useNuxtApp } from '#app'

export async function createOrder(email, orderData) {
    const { $axios } = useNuxtApp()
    return await $axios.post('/orders', {
      email,
      order: orderData
    })
  }