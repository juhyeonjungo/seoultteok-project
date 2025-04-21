// stores/order.js
import { defineStore } from 'pinia'
import { createOrder,fetchOrders } from '@/api/orderapi'

export const useOrderStore = defineStore('order', {
    state: () => ({ orders: []
    }),

    actions: {
    async submitOrder(email, orderData) {
      const res = await createOrder(email, orderData)
      return res
    },
    async fetchOrders(email) {
        const res = await fetchOrders(email)
        this.orders = res.data
      }

  }
})
