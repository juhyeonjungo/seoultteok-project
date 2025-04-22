import { defineStore } from 'pinia'
import { fetchAllOrders, updateOrderStatus } from '@/api/orderadminapi'

export const useOrderAdminStore = defineStore('orderAdmin', {
  state: () => ({
    orders: []
  }),
  actions: {
    async loadOrders() {
      this.orders = await fetchAllOrders()
      console.log(this.orders);
    },
    async changeStatus(orderId, newStatus) {
      console.log("@@@@@@@@@@@@@@@@@@@@@@@");
      await updateOrderStatus(orderId, newStatus)
      const order = this.orders.find(o => o.orderId === orderId)
      if (order) order.status = newStatus
    }
  }
})
