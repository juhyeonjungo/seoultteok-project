<template>
    <div class="mypage">
      <h1>주문 내역</h1>
      <table v-if="orders.length">
        <thead>
          <tr>
            <th>주문번호</th>
            <th>날짜</th>
            <th>총금액</th>
            <th>상태</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="order in orders" :key="order.orderId">
            <td>{{ order.orderId }}</td>
            <td>{{ order.orderDate }}</td>
            <td>{{ order.totalPrice }}원</td>
            <td>{{ order.status }}</td>
          </tr>
        </tbody>
      </table>
      <p v-else>주문 내역이 없습니다.</p>
    </div>
  </template>
  
  <script setup>
  import { onMounted, ref } from 'vue'
  import { useUserStore } from '~/stores/user'
  import { useNuxtApp } from '#app'
  
  const { $axios } = useNuxtApp()
  const userStore = useUserStore()
  const orders = ref([])
  
  onMounted(async () => {
    const res = await $axios.get(`/orders?email=${userStore.userEmail}`)
    orders.value = res.data
  })
  </script>
  
  <style scoped>
  .mypage {
    padding: 40px;
  }
  table {
    width: 100%;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #ddd;
    padding: 12px;
  }
  </style>