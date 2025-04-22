import { useNuxtApp } from '#app'

// 전체 주문 조회
export async function fetchAllOrders() {
  const { $axios } = useNuxtApp()
  const res = await $axios.get('/admin/orders')
  return res.data
}

// 주문 상태 변경
export async function updateOrderStatus(orderId, status) {
  const { $axios } = useNuxtApp()
  await $axios.put(`/admin/orders/${orderId}/status`, { status })
}